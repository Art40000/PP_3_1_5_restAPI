package com.example.pp_3_1_5_restapi.services;

import com.example.pp_3_1_5_restapi.dto.RoleDTO;
import com.example.pp_3_1_5_restapi.models.Role;

import java.util.Set;

public interface RoleService {
    void saveAll(Set<Role> roles);
    Set<Role> findAllRoles();

    Role convertToRole(RoleDTO roleDTO);

    RoleDTO convertToRoleDTO(Role role);
}
