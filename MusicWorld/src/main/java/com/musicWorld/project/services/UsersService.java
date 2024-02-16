package com.musicWorld.project.services;

import com.musicWorld.project.entities.Users;

public interface UsersService {
	public String addUser(Users user);
	public boolean isEmailExists(String email);
	public boolean validateUser(String email, String password);
	public String getRole(String email);
	public Users getUserByEmail(String email);
	public String updateUser(Users user);
}
