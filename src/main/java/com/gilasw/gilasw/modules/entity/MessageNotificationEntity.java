package com.gilasw.gilasw.modules.entity;

import java.io.Serializable;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

class MessageNotificationEntityId implements Serializable {
  private UUID id;
  private UUID notificationID;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getNotificationID() {
    return notificationID;
  }

  public void setNotificationID(UUID notificationID) {
    this.notificationID = notificationID;
  }
}

@Entity(name = "message_notifications")
@IdClass(MessageNotificationEntityId.class)
public class MessageNotificationEntity {

  public MessageNotificationEntity() {
  }

  public MessageNotificationEntity(UUID messageId,
      UUID categoryId,
      UUID channelId,
      UUID userId,
      String messageText) {

    this.id = messageId;
    this.categoryID = categoryId;
    this.channelID = channelId;
    this.userID = userId;
    this.messageText = messageText;

  }

  @Id
  @JdbcTypeCode(Types.VARCHAR)
  private UUID id;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @JdbcTypeCode(Types.VARCHAR)
  @Column(name = "notification_id")
  private UUID notificationID;

  @JdbcTypeCode(Types.VARCHAR)
  @Column(name = "category_id")
  private UUID categoryID;

  @ManyToOne()
  @JoinColumn(name = "channel_id", insertable = false, updatable = false)
  private CategoryEntity categoryEntity;

  @JdbcTypeCode(Types.VARCHAR)
  @Column(name = "channel_id")
  private UUID channelID;

  @JdbcTypeCode(Types.VARCHAR)
  @Column(name = "user_id")
  private UUID userID;

  @Column(name = "message_text")
  private String messageText;

  @CreationTimestamp
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getNotificationID() {
    return notificationID;
  }

  public void setNotificationID(UUID notificationID) {
    this.notificationID = notificationID;
  }

  public UUID getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(UUID categoryID) {
    this.categoryID = categoryID;
  }

  public UUID getChannelID() {
    return channelID;
  }

  public void setChannelID(UUID channelID) {
    this.channelID = channelID;
  }

  public UUID getUserID() {
    return userID;
  }

  public void setUserID(UUID userID) {
    this.userID = userID;
  }

  public String getMessageText() {
    return messageText;
  }

  public void setMessageText(String messageText) {
    this.messageText = messageText;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public CategoryEntity getCategoryEntity() {
    return categoryEntity;
  }

  public void setCategoryEntity(CategoryEntity categoryEntity) {
    this.categoryEntity = categoryEntity;
  }

}

/*
 * 
 * type MessageNotification struct {
 * Message
 * NotificationID model.ID `json:"id" gorm:"primaryKey"`
 * Channel Channel
 * ChannelID model.ID `json:"channelid" gorm:"foreignKey"`
 * User User
 * UserID model.ID `json:"categoryid" gorm:"foreignKey"`
 * }
 * 
 */