package com.gilasw.gilasw.modules.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Hello {

  @GetMapping("/hello")
  public ResponseEntity<Object> get() {

    return ResponseEntity.badRequest().body("Hello World!");

  }

}
