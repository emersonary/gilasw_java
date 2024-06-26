package com.gilasw.gilasw.modules.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gilasw.gilasw.modules.entity.CategoryEntity;
import com.gilasw.gilasw.modules.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class Category {

  @Autowired
  CategoryService categoryService;

  @GetMapping("/")
  public ResponseEntity<List<CategoryEntity>> get() {

    try {
      return ResponseEntity.ok().body(categoryService.categories());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(null);
    }
  }

}
