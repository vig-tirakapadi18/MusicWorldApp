package com.musicWorld.project.services;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.musicWorld.project.entities.Users;
import com.musicWorld.project.repositories.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService {
	@Autowired
	UsersRepository uRepo;

	public String addUser(Users user) {
		uRepo.save(user);
		return "User saved successfully!";
	}

	public boolean isEmailExists(String email) {
		if(uRepo.findByEmail(email) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean validateUser(String email, String password) {
		Users user = uRepo.findByEmail(email);
		boolean isEmailValid = email.equals(user.getEmail());
		boolean isPasswordValid = password.equals(user.getPassword());
		
		if(isEmailValid && isPasswordValid) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getRole(String email) {
		Users user = uRepo.findByEmail(email);
		return user.getRole();
	}
	
	public Users getUserByEmail(String email) {
		return uRepo.findByEmail(email);
	}
	
	public String updateUser(Users user) {
		uRepo.save(user);
		return "User updated successfully!";
	}
}
