package com.team.baap;

import com.team.baap.domain.Role;
import com.team.baap.domain.User;
import com.team.baap.repository.RoleRepository;
import com.team.baap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.*;

@SpringBootApplication
public class BaapApplication {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BaapApplication.class, args);
	}

    @PostConstruct
    public void init() {
        Optional<Role> roleFromDb = roleRepository.findByRole("USER");
        if (!roleFromDb.isPresent()) {
            Role userRole = new Role("USER");
	        roleRepository.saveAndFlush(userRole);
        }
        roleFromDb = roleRepository.findByRole("USER");

        Set<Role> authorities = new HashSet<>();
        authorities.add(roleFromDb.get());
        if (!userRepository.findByUsername("test@test.test").isPresent()) {
            userRepository.save(new User("test@test.test", passwordEncoder.encode("test"), "test", "test", authorities));
        }

        Set<Role> authoritiesFromDb = new HashSet<>();
        authoritiesFromDb.add(roleFromDb.get());
        if (!userRepository.findByUsername("test2@test.test").isPresent()) {
            userRepository.save(new User("test2@test.test", passwordEncoder.encode("test2"), "test2", "test2", authoritiesFromDb));
        }
    }
}
