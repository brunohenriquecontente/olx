package br.com.brunocontentedev.catalog.controller;

import br.com.brunocontentedev.catalog.dto.ProductDTO;
import br.com.brunocontentedev.catalog.exception.ProductNotFoundException;
import br.com.brunocontentedev.catalog.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(
            summary = "Save a product",
            description = "Save a product in the database",
            tags = {"product"}
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO saveProduct(@RequestBody @Valid ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @Operation(
            summary = "Get a product by ID",
            description = "Get a product by id",
            tags = {"product"}
    )
    @GetMapping(value = "{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO findProductById(@PathVariable UUID productId) throws ProductNotFoundException {
        return productService.findProductById(productId);
    }

    @Operation(
            summary = "Delete a product by ID",
            description = "Delete a product by id",
            tags = {"product"}
    )
    @DeleteMapping(value = "{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable UUID productId) {
        productService.deleteById(productId);
    }

    @Operation(
            summary = "Update a product by ID",
            description = "Update a product by id",
            tags = {"product"}
    )
    @PutMapping(value = "{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO updateProductById(@PathVariable UUID productId, @RequestBody ProductDTO productDTO) {
        return productService.updateProductById(productId, productDTO);
    }

    @GetMapping
    @Operation(
            summary = "Get all products pageable by filters",
            description = "Get all products pageable by filters",
            tags = {"product"},
            parameters = {
                    @Parameter(name = "page", description = "Page number", required = false),
                    @Parameter(name = "size", description = "Page size", required = false),
                    @Parameter(name = "sort", description = "Sort order", required = false),
                    @Parameter(name = "orderBy", description = "Order by", required = false)
            }
    )
    @ResponseStatus(HttpStatus.OK)
    public Page<ProductDTO> findAllProductsPageable(
            @ParameterObject ProductDTO productDTO,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(value = "sort", required = false, defaultValue = "asc") String sort,
            @RequestParam(value = "orderBy", required = false, defaultValue = "name") String orderBy
    ) {
        return productService.findAllProductsPageable(productDTO, page, size, sort, orderBy);
    }

}
