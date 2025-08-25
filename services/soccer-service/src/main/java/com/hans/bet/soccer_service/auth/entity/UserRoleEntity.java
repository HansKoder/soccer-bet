package com.hans.bet.soccer_service.auth.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "user_roles")
@IdClass(UserRoleId.class)
public class UserRoleEntity {

    @Id
    @Column(length = 30)
    private String username;

    @Id
    @Column(name = "role_name", length = 20)
    private String role;

    @Column(name = "granted_date")
    private Instant granted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private UserEntity user;

    public Instant getGranted() {
        return granted;
    }

    public void setGranted(Instant granted) {
        this.granted = granted;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "granted=" + granted +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
