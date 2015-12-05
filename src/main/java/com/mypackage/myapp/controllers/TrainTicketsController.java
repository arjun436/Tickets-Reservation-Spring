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

import com.mypackage.myapp.domain.TrainTicket;
import com.mypackage.myapp.service.TrainTicketService;
import com.mypackage.myapp.validators.TrainTicketValidator;

@Controller
@SessionAttributes
public class TrainTicketsController {

	@Autowired
	TrainTicketService trainTicketService;

	TrainTicketValidator trainTicketValidator = new TrainTicketValidator();
	
	
	@RequestMapping("/trainTickets")
	public String listTrainTickets(Map<String, Object> map, HttpServletRequest request) {

		int trainTicketId = ServletRequestUtils.getIntParameter(request, "trainTicketId", -1);

		if (trainTicketId > 0)
			map.put("trainTicket", trainTicketService.getTrainTicket(trainTicketId));
		else
			map.put("trainTicket", new TrainTicket());

		map.put("trainTicketList", trainTicketService.listTrainTicket());

		return "trainTickets";
	}

	@RequestMapping(value = "/addTrainTicket", method = { RequestMethod.POST, RequestMethod.GET }) // po
	public String addTrainTicket(@ModelAttribute("trainTicket") TrainTicket trainTicket, BindingResult result,
			HttpServletRequest request, Map<String, Object> map) {// przyjmujemy

		trainTicketValidator.validate(trainTicket, result);
		
		
		if (result.getErrorCount() == 0) {
				trainTicketService.addTrainTicket(trainTicket);



			return "redirect:trainTickets.html";// z tego kontrolera jestesmy
											// przekierowani na users.html
		}
		
		

		return "trainTickets";
	}
}
