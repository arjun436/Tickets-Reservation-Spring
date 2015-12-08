package com.mypackage.myapp.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mypackage.myapp.domain.PlaneTicket;
import com.mypackage.myapp.service.PlaneTicketService;

@Controller
@SessionAttributes
public class PlaneTicketsListController {

	
	@Autowired
	PlaneTicketService planeTicketService;
	
	@RequestMapping("/planeTicketsList")
	public String listPlaneTickets(Map<String, Object> map, HttpServletRequest request) {

		int planeTicketId = ServletRequestUtils.getIntParameter(request, "planeTicketId", -1);

		if (planeTicketId > 0)
			map.put("planeTicket", planeTicketService.getPlaneTicket(planeTicketId));
		else
			map.put("planeTicket", new PlaneTicket());

		map.put("planeTicketList", planeTicketService.listPlaneTicket());

		return "planeTicketsList";
	}
	@RequestMapping(value = "/deletePlaneTicket/{planeTicketId}", method = ( RequestMethod.GET))
	public String deletePlaneTicket(@PathVariable("planeTicketId") Integer planeTicketId) {
		planeTicketService.removePlaneTicket(planeTicketId);

		return "redirect:/planeTicketsList.html";
	}
}
