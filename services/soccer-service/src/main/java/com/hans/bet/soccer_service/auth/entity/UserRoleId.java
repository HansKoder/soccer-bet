package com.hans.bet.soccer_service.auth.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserRoleId implements Serializable {
    private String username;
    private String role;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UserRoleId that)) return false;
        return Objects.equals(username, that.username) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }
}