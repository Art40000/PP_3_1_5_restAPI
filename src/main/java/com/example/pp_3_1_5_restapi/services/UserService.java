package com.example.pp_3_1_5_restapi.services;

import com.example.pp_3_1_5_restapi.dto.UserDTO;
import com.example.pp_3_1_5_restapi.models.User;

import java.util.*;

public interface UserService {
    void save(User user);

    List<User> findAllUsers();

    void update(int id, User updateUser);

    void delete(int id);

    Optional<User> findUser(int id);

    Optional<User> userByUsername(String username);

    User convertToUser(UserDTO userDTO);

    UserDTO convertToDTO(User user);

}
