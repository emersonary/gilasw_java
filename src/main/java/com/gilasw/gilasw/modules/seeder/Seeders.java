package com.gilasw.gilasw.modules.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.gilasw.gilasw.modules.service.CategoryService;
import com.gilasw.gilasw.modules.service.ChannelService;
import com.gilasw.gilasw.modules.service.UserService;

@Component
public class Seeders implements ApplicationRunner {

  @Autowired
  CategoryService categoryService;

  @Autowired
  ChannelService channelService;

  @Autowired
  UserService userService;

  @Autowired
  JdbcTemplate jdbcTemplate;

  private void createViewsIfNotExist() {

    jdbcTemplate.execute("create view if not exists v_message_notifications as" + " " +
        "select" + " " +
        "message_notifications.id," + " " +
        "message_notifications.notification_id," + " " +
        "users.name UserName," + " " +
        "categories.name CategoryName," + " " +
        "channels.name ChannelName," + " " +
        "message_notifications.message_text," + " " +
        "message_notifications.created_at" + " " +
        "from" + " " +
        "users," + " " +
        "categories," + " " +
        "channels," + " " +
        "message_notifications" + " " +
        "where message_notifications.user_id = users.id" + " " +
        "and message_notifications.category_id = categories.id" + " " +
        "and message_notifications.channel_id = channels.id ;");

    jdbcTemplate.execute("create view if not exists v_messages as" + " " +
        "select " + " " +
        " messages.id," + " " +
        " categories.name CategoryName," + " " +
        " messages.message_text," + " " +
        " messages.created_at" + " " +
        "from " + " " +
        "categories," + " " +
        "messages" + " " +
        "where messages.category_id = categories.id;");
  }

  public void run(ApplicationArguments args) {

    categoryService.loadOrSeed();
    channelService.loadOrSeed();
    userService.loadOrSeed();

    createViewsIfNotExist();

  }

}
