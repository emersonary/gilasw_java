package com.gilasw.gilasw.config;

import java.util.ArrayList;
import java.util.List;

import com.gilasw.gilasw.modules.entity.CategoryEntity;
import com.gilasw.gilasw.modules.entity.ChannelEntity;
import com.gilasw.gilasw.modules.entity.UserEntity;

public class seeds {

  public final static List<CategoryEntity> DefaultCategories() {

    final List<CategoryEntity> categories = new ArrayList<>();

    categories.add(new CategoryEntity("Sports"));
    categories.add(new CategoryEntity("Finance"));
    categories.add(new CategoryEntity("Movies"));

    return categories;

  }

  public final static List<ChannelEntity> DefaultChannels() {

    final List<ChannelEntity> channels = new ArrayList<>();

    channels.add(new ChannelEntity("SMS"));
    channels.add(new ChannelEntity("E-mail"));
    channels.add(new ChannelEntity("Push Notification"));

    return channels;

  }

  public final static List<UserEntity> DefaultUsers() {

    final List<UserEntity> users = new ArrayList<>();

    users.add(new UserEntity("User 1", "user1@fakemail.com", "551199999991"));
    users.add(new UserEntity("User 2", "user2@fakemail.com", "551199999992"));
    users.add(new UserEntity("User 3", "user3@fakemail.com", "551199999993"));

    return users;

  }

}
