package com.gilasw.gilasw.modules.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gilasw.gilasw.modules.repository.UserRepository;

import com.gilasw.gilasw.config.seeds;
import com.gilasw.gilasw.modules.entity.CategoryEntity;
import com.gilasw.gilasw.modules.entity.ChannelEntity;
import com.gilasw.gilasw.modules.entity.UserEntity;

@Service
public class UserService {

  List<UserEntity> users = new ArrayList<>();

  @Autowired
  UserRepository userRepository;

  @Autowired
  CategoryService categoryService;

  @Autowired
  ChannelService channelService;

  public final List<UserEntity> users() {
    return users;
  }

  private List<CategoryEntity> CategoriesFromUser(String username) {

    List<CategoryEntity> categories = new ArrayList<>();

    switch (username) {

      case "User 1":
        categories.add(categoryService.categories.get(0));
        break;

      case "User 2":
        categories.add(categoryService.categories.get(0));
        categories.add(categoryService.categories.get(1));
        break;

      case "User 3":
        categories.add(categoryService.categories.get(0));
        categories.add(categoryService.categories.get(1));
        categories.add(categoryService.categories.get(2));
        break;
    }

    return categories;

  }

  private List<ChannelEntity> ChannelsFromUser(String username) {

    List<ChannelEntity> channels = new ArrayList<>();

    switch (username) {

      case "User 3":
        channels.add(channelService.channels.get(0));
        break;

      case "User 2":
        channels.add(channelService.channels.get(0));
        channels.add(channelService.channels.get(1));
        break;

      case "User 1":
        channels.add(channelService.channels.get(0));
        channels.add(channelService.channels.get(1));
        channels.add(channelService.channels.get(2));
        break;
    }

    return channels;

  }

  private void addDefaultCategoriesAndChannels() {

    for (UserEntity user : users) {

      user.setCategories(CategoriesFromUser(user.getName()));
      user.setChannels(ChannelsFromUser(user.getName()));

    }

  }

  public final void loadOrSeed() {

    users = userRepository.findAll();

    if (users.size() == 0) {

      users = seeds.DefaultUsers();

      userRepository.saveAll(users);

    }

    addDefaultCategoriesAndChannels();

  }

}
