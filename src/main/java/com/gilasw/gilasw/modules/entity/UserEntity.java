package com.gilasw.gilasw.modules.entity;

import java.sql.Types;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity(name = "users")
public class UserEntity {

  public UserEntity(String name, String email, String phone) {
    this.name = name;
    this.email = email;
    this.phone = phone;
  }

  public UserEntity() {

  }

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @JdbcTypeCode(Types.VARCHAR)
  private UUID id;
  private String name;
  private String email;
  private String phone;

  @JsonInclude()
  @Transient
  private List<CategoryEntity> categories;

  @JsonInclude()
  @Transient
  private List<ChannelEntity> channels;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public List<CategoryEntity> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryEntity> categories) {
    this.categories = categories;
  }

  public List<ChannelEntity> getChannels() {
    return channels;
  }

  public void setChannels(List<ChannelEntity> channels) {
    this.channels = channels;
  }

}
