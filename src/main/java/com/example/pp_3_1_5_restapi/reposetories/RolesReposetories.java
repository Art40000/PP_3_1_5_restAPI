package com.example.pp_3_1_5_restapi.reposetories;

import com.example.pp_3_1_5_restapi.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesReposetories extends JpaRepository<Role, Integer> {
}
