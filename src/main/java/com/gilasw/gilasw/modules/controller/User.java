package com.gilasw.gilasw.modules.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gilasw.gilasw.modules.entity.UserEntity;
import com.gilasw.gilasw.modules.service.UserService;

@RestController
@RequestMapping("/users")
public class User {

  @Autowired
  UserService userService;

  @GetMapping("/")
  public ResponseEntity<List<UserEntity>> get() {

    try {
      return ResponseEntity.ok().body(userService.users());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(null);
    }
  }

}