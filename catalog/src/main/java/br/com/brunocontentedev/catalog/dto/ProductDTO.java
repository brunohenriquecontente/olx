package br.com.brunocontentedev.catalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.util.UUID;

public record ProductDTO (
                          UUID productId,

                          @NotNull(message = "Name is required")
                          @NotBlank(message = "Name is required")
                          String name,

                          @Positive(message = "Price must be greater than zero")
                          Double price,

                          @NotNull(message = "Description is required")
                          @NotBlank(message = "Description is required")
                          String description
) implements Serializable {
}
