package com.gilasw.gilasw.modules.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gilasw.gilasw.modules.repository.ChannelRepository;

import com.gilasw.gilasw.config.seeds;
import com.gilasw.gilasw.modules.entity.ChannelEntity;

@Service
public class ChannelService {

  List<ChannelEntity> channels = new ArrayList<>();

  @Autowired
  ChannelRepository ChannelRepository;

  public final List<ChannelEntity> channels() {
    return channels;
  }

  public final void loadOrSeed() {

    channels = ChannelRepository.findAll();

    if (channels.size() == 0) {

      channels = seeds.DefaultChannels();

      ChannelRepository.saveAll(channels);

    }

  }

}
