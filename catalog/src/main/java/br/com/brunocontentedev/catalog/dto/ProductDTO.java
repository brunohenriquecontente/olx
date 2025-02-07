package br.com.brunocontentedev.catalog.dto;

import java.util.UUID;

public record ProductDTO(
                          UUID productId,
                          String name,
                          Double price,
                          String description
) {
}
