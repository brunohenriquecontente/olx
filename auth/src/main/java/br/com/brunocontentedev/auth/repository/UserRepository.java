package br.com.brunocontentedev.auth.repository;

import br.com.brunocontentedev.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    boolean existsByEmail(String email);
}
