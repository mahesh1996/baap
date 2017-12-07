package com.team.baap.controller;

import com.team.baap.domain.User;
import com.team.baap.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping("/home")
    @ResponseBody
    public String greeting() {
        StringBuilder roles = new StringBuilder();
        for(User user: roleRepository.findByRole("USER").get().getUsers()) {
            roles.append(user.getFirstName()).append("\n");
        }
        return roles.toString();
//        return "hi";
    }
}
