package br.com.brunocontentedev.auth.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Table(name = "users")
@Entity
public class UserEntity extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String password;


}
