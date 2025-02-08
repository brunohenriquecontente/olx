package br.com.brunocontentedev.auth.service;

import br.com.brunocontentedev.auth.dto.UserDTO;
import br.com.brunocontentedev.auth.entity.UserEntity;
import br.com.brunocontentedev.auth.exception.UserAlreadyExistsException;
import br.com.brunocontentedev.auth.mapper.UserMapper;
import br.com.brunocontentedev.auth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO save(UserDTO userDTO) throws UserAlreadyExistsException {
        if(userRepository.existsByEmail(userDTO.email())){
            throw UserAlreadyExistsException.alreadyExists("User already exists");
        }

        UserEntity userEntity = UserMapper.INSTANCE.toEntity(userDTO);

        userEntity.setPassword(passwordEncoder.encode(userDTO.password()));

        userRepository.save(userEntity);
        return  UserMapper.INSTANCE.toDTO(userEntity);
    }
}
