package com.gilasw.gilasw.modules.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gilasw.gilasw.modules.repository.CategoryRepository;
import com.gilasw.gilasw.modules.repository.MessageNotificationRepository;
import com.gilasw.gilasw.modules.repository.MessageRepository;
import com.gilasw.gilasw.exceptions.CategoryNotFound;
import com.gilasw.gilasw.modules.dto.MessageCreateDTO;
import com.gilasw.gilasw.modules.dto.MessageNotificationView;
import com.gilasw.gilasw.modules.dto.MessageView;
import com.gilasw.gilasw.modules.entity.CategoryEntity;
import com.gilasw.gilasw.modules.entity.ChannelEntity;
import com.gilasw.gilasw.modules.entity.MessageEntity;
import com.gilasw.gilasw.modules.entity.MessageNotificationEntity;
import com.gilasw.gilasw.modules.entity.UserEntity;

@Service
public class MessageService {

  @Autowired
  MessageRepository messageRepository;

  @Autowired
  MessageNotificationRepository messageNotificationRepository;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  CategoryRepository categoryRepository;

  @Autowired
  UserService userService;

  @Autowired
  CategoryService categoryService;

  private final List<MessageNotificationEntity> createMessageNotifications(MessageEntity messageEntity) {

    List<MessageNotificationEntity> messageNotifications = new ArrayList<>();

    for (UserEntity user : userService.users()) {

      for (CategoryEntity categoryEntity : categoryService.categories()) {

        if (categoryEntity.getId().equals(messageEntity.getCategoryID())) {

          for (ChannelEntity channel : user.getChannels()) {

            MessageNotificationEntity messageNotification = new MessageNotificationEntity(messageEntity.getId(),
                categoryEntity.getId(),
                channel.getId(),
                user.getId(),
                messageEntity.getMessageText());

            messageNotificationRepository.save(messageNotification);

          }

        }

      }

    }

    return messageNotifications;

  }

  public final MessageEntity createMessage(MessageCreateDTO messageCreateDTO) {

    if (!categoryRepository.findById(messageCreateDTO.categoryId()).isPresent()) {

      throw new CategoryNotFound();

    }

    MessageEntity message = new MessageEntity(messageCreateDTO.categoryId(), messageCreateDTO.messagetext());

    MessageEntity messageEntity = messageRepository.save(message);

    createMessageNotifications(messageEntity);

    return messageEntity;

  }

  public final List<MessageView> lastMessages(Integer limit) {

    List<MessageView> messages = new ArrayList<>();

    List<Map<String, Object>> rows = jdbcTemplate
        .queryForList("select * from v_Messages order by created_at desc limit " + limit);

    for (Map<String, Object> row : rows) {

      MessageView message = new MessageView();

      message.setId(UUID.fromString((String) row.get("id")));
      message.setCategoryName((String) row.get("CategoryName"));
      message.setMessage_text((String) row.get("message_text"));

      // System.out.println(row.get("created_at"));

      // message.setCreated_at((LocalDateTime) row.get("created_at"));

      messages.add(message);

    }

    return messages;

  }

  public final List<MessageNotificationView> lastNotifications(Integer limit) {

    List<MessageNotificationView> messages = new ArrayList<>();

    List<Map<String, Object>> rows = jdbcTemplate
        .queryForList("select * from v_Message_Notifications order by created_at desc limit " + limit);

    for (Map<String, Object> row : rows) {

      MessageNotificationView message = new MessageNotificationView();

      message.setId(UUID.fromString((String) row.get("id")));
      message.setNotification_id(UUID.fromString((String) row.get("notification_id")));
      message.setCategoryName((String) row.get("CategoryName"));
      message.setChannelName((String) row.get("ChannelName"));
      message.setUserName((String) row.get("UserName"));
      message.setMessage_text((String) row.get("message_text"));
      // message.setCreated_at((LocalDateTime) row.get("created_at"));

      messages.add(message);

    }

    return messages;

  }

}
