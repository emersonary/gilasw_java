package com.gilasw.gilasw.modules.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class MessageNotificationView {
  private UUID id;
  private UUID notification_id;
  private String UserName;
  private String CategoryName;
  private String ChannelName;
  private String message_text;
  private LocalDateTime created_at;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getNotification_id() {
    return notification_id;
  }

  public void setNotification_id(UUID notification_id) {
    this.notification_id = notification_id;
  }

  public String getUserName() {
    return UserName;
  }

  public void setUserName(String userName) {
    UserName = userName;
  }

  public String getCategoryName() {
    return CategoryName;
  }

  public void setCategoryName(String categoryName) {
    CategoryName = categoryName;
  }

  public String getChannelName() {
    return ChannelName;
  }

  public void setChannelName(String channelName) {
    ChannelName = channelName;
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

};