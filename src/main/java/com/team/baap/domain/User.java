package com.team.baap.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * This domain class represents User entity
 * @author Mahesh Bhuva
 * @since 0.0.1
 */
@Entity
public class User {

    @GeneratedValue
    @Id
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Role> roles;
}
