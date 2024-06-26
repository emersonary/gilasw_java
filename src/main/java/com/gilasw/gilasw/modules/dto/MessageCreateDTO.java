package com.gilasw.gilasw.modules.dto;

import java.util.UUID;

public record MessageCreateDTO(UUID categoryId, String messagetext) {
};