package br.com.brunocontentedev.auth.dto.response;

import java.util.UUID;

public record UserResponseDTO(
        UUID userId,
        String firstName,
        String lastName,
        String email,
        Boolean isAccountNonExpired,
        Boolean isCredentialsNonExpired,
        Boolean isEnabled,
        Boolean isAccountNonLocked
) {
}
