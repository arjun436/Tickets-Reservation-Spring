package com.mypackage.myapp.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mypackage.myapp.domain.User;
import com.mypackage.myapp.domain.UserRole;
import com.mypackage.myapp.service.UserService;
//import com.mypackage.myapp.validators.UserValidator;

@Controller
@SessionAttributes
public class UserController {

	@Autowired
	UserService userService;

//	UserValidator userValidator = new UserValidator();

	@RequestMapping("/users")
	public String listUsers(Map<String, Object> map, HttpServletRequest request) {

		int userId = ServletRequestUtils.getIntParameter(request, "userId", -1);

		if (userId > 0)
			map.put("user", userService.getUser(userId));
		else
			map.put("user", new User());

		map.put("userList", userService.listUser());

		return "user";
	}

	@RequestMapping(value = "/addUser", method = { RequestMethod.POST, RequestMethod.GET }) // po
	// wcisnieciu
	// add
	// dodane RequestMethod.GET by internacjonalizacja dzialala
	public String addContact(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request,
			Map<String, Object> map) {// przyjmujemy
		// uzytkownika
//		userValidator.validate(user, result);
		// System.out.println("First Name: " + user.getFirstname() + " Last
		// Name: " + user.getLastname() + " Tel.: "
		// + user.getTelephone() + " Email: " + user.getEmail());

		if (result.getErrorCount() == 0) {
			if (user.getId() == 0)
				userService.addUser(user);
			else
				userService.editUser(user);


			return "redirect:users.html";// z tego kontrolera jestesmy
											// przekierowani na users.html
		}

		map.put("userList", userService.listUser());
		return "user";
	}

	@RequestMapping("/delete/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {
		userService.removeUser(userId);

		return "redirect:/users.html";
	}



	@RequestMapping("/userRole")
	public ModelAndView showUserRole() {

		return new ModelAndView("userRole", "userRole", new UserRole());
	}

	@RequestMapping(value = "/addUserRole", method = RequestMethod.POST)
	public String addUserRole(@ModelAttribute("userRole") UserRole userRole, BindingResult result,
			HttpServletRequest request, Map<String, Object> map) {

		userService.addUserRole(userRole);

		return "redirect:home.html";
	}

}
