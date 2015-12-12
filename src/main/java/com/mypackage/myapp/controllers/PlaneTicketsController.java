package com.mypackage.myapp.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mypackage.myapp.domain.PlaneTicket;
import com.mypackage.myapp.service.PlaneTicketService;
import com.mypackage.myapp.validators.PlaneTicketValidator;

@Controller
@SessionAttributes
public class PlaneTicketsController {

	@Autowired
	PlaneTicketService planeTicketService;

	PlaneTicketValidator planeTicketValidator = new PlaneTicketValidator();

	
	@RequestMapping("/planeTickets")
	public String listPlaneTickets(Map<String, Object> map, HttpServletRequest request) {

		int planeTicketId = ServletRequestUtils.getIntParameter(request, "planeTicketId", -1);
		if (planeTicketId > 0)
			map.put("planeTicket", planeTicketService.getPlaneTicket(planeTicketId));
		else
			map.put("planeTicket", new PlaneTicket());

		map.put("planeTicketList", planeTicketService.listPlaneTicket());

		return "planeTickets";
	}

	@RequestMapping(value = "/addPlaneTicket", method = ( RequestMethod.POST)) // po
	public String addPlaneTicket(@ModelAttribute("planeTicket") PlaneTicket planeTicket, BindingResult result,
			HttpServletRequest request, Map<String, Object> map) {// przyjmujemy

		planeTicketValidator.validate(planeTicket, result);
		
		
		if (result.getErrorCount() == 0) {
				
				if (planeTicket.getId() == 0)
					planeTicketService.addPlaneTicket(planeTicket);
				else
					planeTicketService.editPlaneTicket(planeTicket);



			return "redirect:planeTicketsList.html";// z tego kontrolera jestesmy
											// przekierowani na users.html
		}
		
		

		return "planeTickets";
	}
}

// @RequestMapping("/delete/{userId}")
// public String deleteUser(@PathVariable("userId") Integer userId) {
// userService.removeUser(userId);
//
// return "redirect:/users.html";
// }
