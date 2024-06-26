package com.gilasw.gilasw.modules.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class MessageView {
  private UUID id;
  private String CategoryName;
  private String message_text;
  private LocalDateTime created_at;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getCategoryName() {
    return CategoryName;
  }

  public void setCategoryName(String categoryName) {
    CategoryName = categoryName;
  }

  public String getMessage_text() {
    return message_text;
  }

  public void setMessage_text(String message_text) {
    this.message_text = message_text;
  }

  public LocalDateTime getCreated_at() {
    return created_at;
  }

  public void setCreated_at(LocalDateTime created_at) {
    this.created_at = created_at;
  }

}