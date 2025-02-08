package br.com.brunocontentedev.catalog.controller;

import br.com.brunocontentedev.catalog.dto.ProductDTO;
import br.com.brunocontentedev.catalog.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping
    public Page<ProductDTO> findAllProductsPageable(
            ProductDTO productDTO,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false, defaultValue = "asc") String sort,
            @RequestParam(value = "orderBy", required = false, defaultValue = "name") String orderBy
    ) {
        return productService.findAllProductsPageable(productDTO, page, size, sort, orderBy);
    }

}
