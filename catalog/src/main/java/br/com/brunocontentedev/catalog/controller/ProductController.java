package br.com.brunocontentedev.catalog.controller;

import br.com.brunocontentedev.catalog.dto.ProductDTO;
import br.com.brunocontentedev.catalog.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @GetMapping(value = "{productId}")
    public ProductDTO findProductById(@PathVariable UUID productId) {
        return productService.findProductById(productId);
    }

    @DeleteMapping(value = "{productId}")
    public void deleteProductById(@PathVariable UUID productId) {
        productService.deleteById(productId);
    }

    @PutMapping(value = "{productId}")
    public ProductDTO updateProductById(@PathVariable UUID productId, @RequestBody ProductDTO productDTO) {
        return productService.updateProductById(productId, productDTO);
    }

//    @GetMapping
//    public Page<ProductDTO> findAllProducts(Pageable pageable) {
//        return productService.findAllProducts(pageable);
//    }

}
