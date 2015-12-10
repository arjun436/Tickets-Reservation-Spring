package com.mypackage.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypackage.myapp.dao.UserDAO;
import com.mypackage.myapp.domain.User;
import com.mypackage.myapp.domain.UserRole;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Transactional
	public void addUserAdmin(User user) {
		user.getUserRole().add(userDAO.findRoleByName("ROLE_USER"));
		user.getUserRole().add(userDAO.findRoleByName("ROLE_ADMIN"));
		user.setPassword(hashPassword(user.getPassword()));
		userDAO.addUser(user);
	}
	
	@Transactional
	public void addUser(User user) {
		user.getUserRole().add(userDAO.findRoleByName("ROLE_USER"));
		user.setPassword(hashPassword(user.getPassword()));
		userDAO.addUser(user);
	}

	@Transactional
	public void editUser(User user) {
		user.setPassword(hashPassword(user.getPassword()));
		userDAO.editUser(user);
	}

	@Transactional
	public List<User> listUser() {

		return userDAO.listUser();
	}

	@Transactional
	public void removeUser(int id) {
		userDAO.removeUser(id);
	}

	@Transactional
	public User getUser(int id) {
		return userDAO.getUser(id);
	}

	@Transactional
	public String hashPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}

	public void addUserRole(UserRole userRole) {
		userDAO.addRole(userRole);
	}

	public List<UserRole> listUserRole() {
		return userDAO.listUserRole();
	}

	public void removeUserRole(int id) {
		userDAO.removeUserRole(id);
	}

	public UserRole getUserRole(int id) {
		return userDAO.getUserRole(id);
	}

	@Override
	public User findByLogin(String login) {
		// TODO Auto-generated method stub
		return userDAO.findByLogin(login);
	}


}
