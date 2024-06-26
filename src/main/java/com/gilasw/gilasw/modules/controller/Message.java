package com.gilasw.gilasw.modules.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gilasw.gilasw.modules.dto.MessageCreateDTO;
import com.gilasw.gilasw.modules.dto.MessageNotificationView;
import com.gilasw.gilasw.modules.dto.MessageView;
import com.gilasw.gilasw.modules.entity.MessageEntity;
import com.gilasw.gilasw.modules.service.MessageService;

@RestController
@RequestMapping("/messages")
public class Message {

  @Autowired
  MessageService messageService;

  @GetMapping("/lastmessages")
  public ResponseEntity<List<MessageView>> getLastMessages() {

    try {
      return ResponseEntity.ok().body(messageService.lastMessages(10));
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return ResponseEntity.badRequest().body(null);
    }
  }

  @GetMapping("/lastnotifications")
  public ResponseEntity<List<MessageNotificationView>> getLastNotifications() {

    try {
      return ResponseEntity.ok().body(messageService.lastNotifications(10));
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return ResponseEntity.badRequest().body(null);
    }
  }

  @PostMapping("/create")
  public ResponseEntity<MessageEntity> create(@RequestBody MessageCreateDTO messagecreateDTO) {

    try {
      return ResponseEntity.ok().body(messageService.createMessage(messagecreateDTO));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(null);
    }
  }

}
