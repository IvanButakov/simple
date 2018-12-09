package com.but.simple.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, USER, TESTUSER;

    @Override
    public String getAuthority() {
        return name();
    }
}
