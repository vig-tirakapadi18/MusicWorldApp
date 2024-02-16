package com.musicWorld.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.musicWorld.project.entities.Users;
import com.musicWorld.project.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
    @Autowired
    UsersService uService;

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute Users user) {
        boolean isUserExists = uService.isEmailExists(user.getEmail());
        if (isUserExists) {
//            System.out.println("User already exists!");
            return "registerFail";
        } else {
            uService.addUser(user);
            return "registerSuccess";
        }
    }

    @PostMapping("/verify-user")
    public String verifyUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
        boolean isUserValid = uService.validateUser(email, password);
        if (isUserValid) {
        	session.setAttribute("email", email);
        	
        	if(uService.getRole(email).equals("admin"))
        		return "adminHome";
        	else
        		return "customerHome";
        } else {
            return "loginFail";
        }
    }
}
