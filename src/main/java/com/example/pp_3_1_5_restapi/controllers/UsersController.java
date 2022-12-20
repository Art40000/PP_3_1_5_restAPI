package com.example.pp_3_1_5_restapi.controllers;

import com.example.pp_3_1_5_restapi.models.User;
import com.example.pp_3_1_5_restapi.security.MyUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class UsersController {

    @GetMapping("/api/user")
    @ResponseBody
    public ResponseEntity<User> showUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails myUserDetails = (MyUserDetails) auth.getPrincipal();
        return new ResponseEntity<>(myUserDetails.getUser(), HttpStatus.OK);
    }

    @GetMapping("/user")
    public String userPage() {
        return "user";
    }
}
