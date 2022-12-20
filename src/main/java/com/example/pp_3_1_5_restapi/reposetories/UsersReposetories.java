package com.example.pp_3_1_5_restapi.reposetories;


import com.example.pp_3_1_5_restapi.models.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsersReposetories extends JpaRepository<User, Integer> {
    @EntityGraph(value = "User.role", type = EntityGraph.EntityGraphType.LOAD)
    Optional<User> findByUsername(String username);
}
