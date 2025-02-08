package br.com.brunocontentedev.catalog.mapper;

import br.com.brunocontentedev.catalog.dto.ProductDTO;
import br.com.brunocontentedev.catalog.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductEntity toEntity(ProductDTO productDTO);

    ProductDTO toDTO(ProductEntity productEntity);

}
