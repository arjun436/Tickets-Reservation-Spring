package com.mypackage.myapp.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mypackage.myapp.domain.PlaneTicket;
import com.mypackage.myapp.service.TrainTicketService;

@Controller
@SessionAttributes
public class TrainTicketsListController {

	
	@Autowired
	TrainTicketService trainTicketService;
	
	@RequestMapping("/trainTicketsList")
	public String listTrainTickets(Map<String, Object> map, HttpServletRequest request) {

		int trainTicketId = ServletRequestUtils.getIntParameter(request, "trainTicketId", -1);

		if (trainTicketId > 0)
			map.put("trainTicket", trainTicketService.getTrainTicket(trainTicketId));
		else
			map.put("trainTicket", new PlaneTicket());

		map.put("trainTicketList", trainTicketService.listTrainTicket());

		return "trainTicketsList";
	}
	@RequestMapping("/deleteTrainTicket/{trainTicketId}")
	public String deletePlaneTicket(@PathVariable("trainTicketId") Integer trainTicketId) {
		trainTicketService.removeTrainTicket(trainTicketId);

		return "redirect:/trainTicketsList.html";
	}
}
