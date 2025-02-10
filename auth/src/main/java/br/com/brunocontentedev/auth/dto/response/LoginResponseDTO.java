package br.com.brunocontentedev.auth.dto.response;

public record LoginResponseDTO(String accessToken, Long expiresIn, String refreshToken) {
}
