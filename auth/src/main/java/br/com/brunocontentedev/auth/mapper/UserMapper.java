package br.com.brunocontentedev.auth.mapper;

import br.com.brunocontentedev.auth.dto.UserDTO;
import br.com.brunocontentedev.auth.entity.UserEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity toEntity(UserDTO userDTO);

    UserDTO toDTO(UserEntity userEntity);

}
