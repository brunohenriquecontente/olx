package br.com.brunocontentedev.auth.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserDTO(UUID userId, String name, String email, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
