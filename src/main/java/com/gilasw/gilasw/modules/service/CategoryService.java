package com.gilasw.gilasw.modules.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gilasw.gilasw.config.seeds;
import com.gilasw.gilasw.modules.entity.CategoryEntity;
import com.gilasw.gilasw.modules.repository.CategoryRepository;

@Service
public class CategoryService {

  List<CategoryEntity> categories = new ArrayList<>();

  @Autowired
  CategoryRepository categoryRepository;

  public final List<CategoryEntity> categories() {
    return categories;
  }

  public final void loadOrSeed() {

    categories = categoryRepository.findAll();

    if (categories.size() == 0) {

      categories = seeds.DefaultCategories();

      categoryRepository.saveAll(categories);

    }

  }

}
