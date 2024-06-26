package com.gilasw.gilasw.modules.entity;

import java.sql.Types;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "categories")
public class CategoryEntity {

  public CategoryEntity(String name) {
    this.name = name;
  }

  public CategoryEntity() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @JdbcTypeCode(Types.VARCHAR)
  private UUID id;
  private String name;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
