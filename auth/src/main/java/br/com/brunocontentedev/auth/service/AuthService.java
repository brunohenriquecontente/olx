package br.com.brunocontentedev.auth.service;


import br.com.brunocontentedev.auth.dto.response.LoginResponseDTO;
import br.com.brunocontentedev.auth.dto.request.LoginResquestDTO;
import br.com.brunocontentedev.auth.entity.UserEntity;
import br.com.brunocontentedev.auth.exception.BadCredentialsException;
import br.com.brunocontentedev.auth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final JwtEncoder jwtEncoder;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, JwtEncoder jwtEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtEncoder = jwtEncoder;
    }

    public LoginResponseDTO login(LoginResquestDTO loginResquestDTO){

        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(loginResquestDTO.email());

         if(userEntityOptional.isEmpty()) {
             throw BadCredentialsException.from("Email ou senha incorretos");
         }
         UserEntity userEntity = userEntityOptional.get();

        Boolean isValidLogin =  bCryptPasswordEncoder.matches(loginResquestDTO.password(), userEntity.getPassword());

        if(Boolean.FALSE.equals(isValidLogin)){
           throw BadCredentialsException.from("Email ou senha incorretos");
        }
        return generateToken(userEntity);
    }


    private LoginResponseDTO generateToken(UserEntity userEntity) {
        long tokenExpiresIn = 360L;
        long refreshTokenExpiresIn = 3600L;


        var now = Instant.now();
        var claimsToken = JwtClaimsSet.builder()
                .issuer("auth-service")
                .subject(userEntity.getEmail())
                .claim("given_name", userEntity.getFirstName() != null ? userEntity.getFirstName() : "")
                .claim("family_name", userEntity.getLastName() != null ? userEntity.getLastName() : "")
                .claim("email", userEntity.getEmail())
                .claim("roles", userEntity.getRoles())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(tokenExpiresIn))
                .build();

        var claimsRefreshToken = JwtClaimsSet.builder()
                .issuer("auth-service")
                .subject(userEntity.getEmail())
                .claim("given_name", userEntity.getFirstName() != null ? userEntity.getFirstName() : "")
                .claim("family_name", userEntity.getLastName() != null ? userEntity.getLastName() : "")
                .claim("email", userEntity.getEmail())
                .claim("roles", userEntity.getRoles())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(refreshTokenExpiresIn))
                .build();

        var jwtToken = jwtEncoder.encode(JwtEncoderParameters.from(claimsToken)).getTokenValue();
        var jwtRefreshToken = jwtEncoder.encode(JwtEncoderParameters.from(claimsRefreshToken)).getTokenValue();

        return new LoginResponseDTO(jwtToken, tokenExpiresIn, jwtRefreshToken);
    }
}
