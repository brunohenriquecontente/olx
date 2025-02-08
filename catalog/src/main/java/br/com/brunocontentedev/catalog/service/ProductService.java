package br.com.brunocontentedev.catalog.service;

import br.com.brunocontentedev.catalog.dto.ProductDTO;
import br.com.brunocontentedev.catalog.entity.ProductEntity;
import br.com.brunocontentedev.catalog.mapper.ProductMapper;
import br.com.brunocontentedev.catalog.repository.ProductRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO saveProduct(ProductDTO productDTO) {
        ProductEntity productEntity = ProductMapper.INSTANCE.toEntity(productDTO);
        productRepository.save(productEntity);
        return ProductMapper.INSTANCE.toDTO(productEntity);
    }

    public ProductDTO findProductById(UUID productId) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow();
        return ProductMapper.INSTANCE.toDTO(productEntity);
    }

    public void deleteById(UUID productId) {
        productRepository.deleteById(productId);
    }

    public ProductDTO updateProductById(UUID productId, ProductDTO productDTO) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow();
        productEntity = ProductMapper.INSTANCE.toEntity(productDTO);
        productRepository.save(productEntity);
        return ProductMapper.INSTANCE.toDTO(productEntity);
    }

    public Page<ProductDTO> findAllProductsPageable(ProductDTO productDTO, int page, int size, String sort, String orderBy) {
        Sort.Direction direction =   "desc".equalsIgnoreCase(sort) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, orderBy));
        ProductEntity productEntity = ProductMapper.INSTANCE.toEntity(productDTO);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<ProductEntity> example = Example.of(productEntity, exampleMatcher);
        Page<ProductEntity> products = productRepository.findAll(example, pageable);


        return products.map(ProductMapper.INSTANCE::toDTO);
    }

}
