package br.com.brunocontentedev.catalog.service;

import br.com.brunocontentedev.catalog.dto.ProductDTO;
import br.com.brunocontentedev.catalog.entity.ProductEntity;
import br.com.brunocontentedev.catalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO saveProduct(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDTO.name());
        productEntity.setPrice(productDTO.price());
        productEntity.setDescription(productDTO.description());
        productEntity = productRepository.save(productEntity);
        return new ProductDTO(productEntity.getProductId(), productEntity.getName(), productEntity.getPrice(), productEntity.getDescription());
    }

    public ProductDTO findProductById(UUID productId) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow();
        return new ProductDTO(productEntity.getProductId(), productEntity.getName(), productEntity.getPrice(), productEntity.getDescription());
    }

    public void deleteById(UUID productId) {
        productRepository.deleteById(productId);
    }

    public ProductDTO updateProductById(UUID productId, ProductDTO productDTO) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow();
        productEntity.setName(productDTO.name());
        productEntity.setPrice(productDTO.price());
        productEntity.setDescription(productDTO.description());
        productRepository.save(productEntity);
        return new ProductDTO(productEntity.getProductId(), productEntity.getName(), productEntity.getPrice(), productEntity.getDescription());
    }

}
