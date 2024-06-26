package com.gilasw.gilasw.modules.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gilasw.gilasw.modules.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

}