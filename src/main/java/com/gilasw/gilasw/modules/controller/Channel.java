package com.gilasw.gilasw.modules.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gilasw.gilasw.modules.entity.ChannelEntity;
import com.gilasw.gilasw.modules.service.ChannelService;

@RestController
@RequestMapping("/channels")
public class Channel {

  @Autowired
  ChannelService channelService;

  @GetMapping("/")
  public ResponseEntity<List<ChannelEntity>> get() {

    try {
      return ResponseEntity.ok().body(channelService.channels());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(null);
    }
  }

}