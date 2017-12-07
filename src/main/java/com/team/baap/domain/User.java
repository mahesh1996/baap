package com.team.baap.domain;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;

/**
 * This domain class represents User entity
 * @author Mahesh Bhuva
 * @since 0.0.1
 */
@Entity
public class User implements UserDetails {

    private String firstName;
    private String lastName;
    @Id
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> authorities;

    public User(String username, String password, String firstName, String lastName,
                Set<Role> authorities) {

        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorities = authorities;
        this.password = password;
    }

    protected User() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Set<Role> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
