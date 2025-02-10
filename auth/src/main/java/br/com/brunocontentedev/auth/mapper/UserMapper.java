package br.com.brunocontentedev.auth.mapper;

import br.com.brunocontentedev.auth.dto.request.UserRegisterDTO;
import br.com.brunocontentedev.auth.dto.response.UserResponseDTO;
import br.com.brunocontentedev.auth.entity.UserEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity toEntity(UserRegisterDTO userDTO);

    UserEntity toEntity(UserResponseDTO userDTO);

    UserResponseDTO toDTO(UserEntity userEntity);


}
