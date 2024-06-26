package com.gilasw.gilasw.modules.entity;

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

@Entity(name = "messages")
public class MessageEntity {

  public MessageEntity(UUID categoryID,
      String messageText) {
    this.categoryID = categoryID;
    this.messageText = messageText;
  }

  public MessageEntity(UUID id,
      UUID categoryID,
      String messageText,
      LocalDateTime createdAt) {
    this.id = id;
    this.categoryID = categoryID;
    this.messageText = messageText;
    this.createdAt = createdAt;
  }

  public MessageEntity() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @JdbcTypeCode(Types.VARCHAR)
  private UUID id;

  @JdbcTypeCode(Types.VARCHAR)
  @Column(name = "category_id")
  private UUID categoryID;

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

  public UUID getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(UUID categoryID) {
    this.categoryID = categoryID;
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

}

/*
 * type Message struct {
 * ID model.ID `json:"id" gorm:"primaryKey"`
 * Category Category `json:"category" gorm:"primaryKey"`
 * CategoryID model.ID `json:"categoryid" gorm:"foreignKey"`
 * MessageText string `json:"messagetext" gorm:"not null"`
 * CreatedAt time.Time `json:"createdat"`
 * }
 */
