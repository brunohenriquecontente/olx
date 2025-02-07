package br.com.brunocontentedev.catalog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID productId;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private String description;

}
