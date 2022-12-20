package com.example.pp_3_1_5_restapi.services;

import com.example.pp_3_1_5_restapi.dto.UserDTO;
import com.example.pp_3_1_5_restapi.models.User;
import com.example.pp_3_1_5_restapi.reposetories.UsersReposetories;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UsersReposetories usersReposetories;
    private final PasswordEncoder passwordEncoder;

    private final RoleService roleService;

    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UsersReposetories usersReposetories, PasswordEncoder passwordEncoder, RoleService roleService, ModelMapper mapper) {
        this.usersReposetories = usersReposetories;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.mapper = mapper;
    }
    @Transactional
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersReposetories.save(user);
    }

    public List<User> findAllUsers() {
        return usersReposetories.findAll();
    }

    @Transactional
    public void update(int id, User updateUser) {
        updateUser.setId(id);
        save(updateUser);
    }

    @Transactional
    public void delete(int id) {
        usersReposetories.deleteById(id);
    }

    @Override
    public Optional<User> findUser(int id) {
        return usersReposetories.findById(id);
    }

    public Optional<User> userByUsername(String username) {
        return usersReposetories.findByUsername(username);
    }

    @Override
    public User convertToUser(UserDTO userDTO) {
        return mapper.map(userDTO, User.class);
    }

    @Override
    public UserDTO convertToDTO(User user) {
        return mapper.map(user, UserDTO.class);
    }

}
