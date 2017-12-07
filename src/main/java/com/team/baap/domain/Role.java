package com.team.baap.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * This domain class represents the Role Entity for User Entity
 * @author Mahesh Bhuva
 * @since 0.0.1
 */
@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue
    private Long id;

    private String role;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private Set<User> users;

    public Role(String role) {
        this.role = role;
    }

    protected Role() {
    }

    public Set<User> getUsers() {
        return users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
