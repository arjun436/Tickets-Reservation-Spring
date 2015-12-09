package com.mypackage.myapp.service;

import java.util.List;

import com.mypackage.myapp.domain.User;
import com.mypackage.myapp.domain.UserRole;

public interface UserService {

	public void addUserAdmin(User user);
	
	public void addUser(User user);


	public void editUser(User user);

	public List<User> listUser();

	public void removeUser(int id);

	public User getUser(int id);

	public String hashPassword(String password);

	public void addUserRole(UserRole userRole);

	public List<UserRole> listUserRole();

	public void removeUserRole(int id);

	public UserRole getUserRole(int id);

}
