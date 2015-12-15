package com.mypackage.myapp.controllers;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mypackage.myapp.domain.Mail;
import com.mypackage.myapp.domain.User;
import com.mypackage.myapp.domain.UserRole;
import com.mypackage.myapp.service.UserService;
import com.mypackage.myapp.validators.UserRoleValidator;
import com.mypackage.myapp.validators.UserValidator;

@Controller
@SessionAttributes
public class UserController {

	@Autowired
	UserService userService;

	UserValidator userValidator = new UserValidator();
	UserRoleValidator userRoleValidator = new UserRoleValidator();

	@RequestMapping("/user")
	public String user(Map<String, Object> map, HttpServletRequest request) {

		int userId = ServletRequestUtils.getIntParameter(request, "userId", -1);

		if (userId > 0)
			map.put("user", userService.getUser(userId));
		else
			map.put("user", new User());

		map.put("userList", userService.listUser());

		return "user";
	}

	@RequestMapping("/usersList")
	public String listOfUsers(Map<String, Object> map, HttpServletRequest request) {

		map.put("usersList", userService.listUser());

		return "usersList";
	}

	@RequestMapping(value = "/addUser", method = { RequestMethod.POST }) // po

	public String addUser(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request,
			Map<String, Object> map) {

		userValidator.validate(user, result);

		if (result.getErrorCount() == 0) {
			// GET CURRENT LOGGED USER authorities
			@SuppressWarnings("unchecked")
			Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
					.getContext().getAuthentication().getAuthorities();

			if (authorities != null) {
				for (Iterator it = authorities.iterator(); it.hasNext();) {
					Object candidate = it.next();
					if (candidate.toString().equals("ROLE_ADMIN")) {

						userService.addUserAdmin(user);// ADMIN DODAJE Z
														// UPRAWNIENIAMI ADMINA
														// I USERA
					}
					if (candidate.toString().equals("ROLE_ANONYMOUS")) {

						userService.addUser(user);// GOSC MOZE MIEC TYLKO
						// UPTRAWNIENIA USERA
					}

				}
			}

			// send email
			ApplicationContext context = new ClassPathXmlApplicationContext("Spring-mail.xml");

			Mail mm = (Mail) context.getBean("mailMail");
			mm.sendMail("ticktwo.ticktwo@gmail.com", user.getEmail(), "TickTwo Welcome " + user.getLogin() + "!",
					"Your account was created. Thank You!");

			return "redirect:home.html";

		}

		return "user";

		// z tego kontrolera jestesmy
		// przekierowani na users.html
		// }

		// map.put("userList", userService.listUser());
		// return "user";
	}

	@RequestMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {
		userService.removeUser(userId);

		return "redirect:/usersList.html";
	}

	@RequestMapping("/userRole")
	public ModelAndView showUserRole() {

		return new ModelAndView("userRole", "userRole", new UserRole());
	}

	@RequestMapping(value = "/addUserRole", method = RequestMethod.POST)
	public String addUserRole(@ModelAttribute("userRole") UserRole userRole, BindingResult result,
			HttpServletRequest request, Map<String, Object> map) {

		userRoleValidator.validate(userRole, result);

		if (result.getErrorCount() == 0) {

			userService.addUserRole(userRole);

			return "redirect:home.html";

		}

		return "userRole";
	}

}
