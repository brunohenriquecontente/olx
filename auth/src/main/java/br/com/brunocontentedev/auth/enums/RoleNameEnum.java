package br.com.brunocontentedev.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleNameEnum {

    ROLE_USER("USER",1),
    ROLE_ADMIN("ADMIN",2);

    public String roleNameEnum;
    public Integer key;
}

