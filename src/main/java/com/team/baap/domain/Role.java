package com.team.baap.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * This domain class represents the Role Entity for User Entity
 * @author Mahesh Bhuva
 * @since 0.0.1
 */
@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private String role;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users;
}
