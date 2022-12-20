package com.example.pp_3_1_5_restapi.security;

import com.example.pp_3_1_5_restapi.models.Role;
import com.example.pp_3_1_5_restapi.models.User;
import com.example.pp_3_1_5_restapi.services.RoleService;
import com.example.pp_3_1_5_restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * password - admin
 */
@Component
public class AccountOfAdmin {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AccountOfAdmin(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void admin() {
        User admin = new User("Art","Em",
                "admin", 40, "admin");
        Role roleUser  = new Role("ROLE_USER");
        Role roleAdmin  = new Role("ROLE_ADMIN");
        if (userService.userByUsername(admin.getUsername()).isEmpty()) {
            admin.setRoleList(new HashSet<>(Set.of(roleUser, roleAdmin)));
            roleService.saveAll(new HashSet<>(Set.of(roleUser, roleAdmin)));
            userService.save(admin);
        }
    }
}
