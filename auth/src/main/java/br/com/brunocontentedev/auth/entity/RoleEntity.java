package br.com.brunocontentedev.auth.entity;

import br.com.brunocontentedev.auth.enums.RoleNameEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
@Getter
@Setter
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Enumerated
    @Column(unique = true)
    private RoleNameEnum name;
}
