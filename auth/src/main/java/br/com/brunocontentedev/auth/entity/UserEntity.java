package br.com.brunocontentedev.auth.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Table(name = "users")
@Entity
public class UserEntity extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    @Column(unique = true)
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private Boolean isAccountNonExpired;

    private Boolean isCredentialsNonExpired;

    private Boolean isEnabled;

    private Boolean isAccountNonLocked;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles;
}
