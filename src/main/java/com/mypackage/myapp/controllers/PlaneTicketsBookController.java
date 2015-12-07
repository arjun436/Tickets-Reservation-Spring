package com.mypackage.myapp.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mypackage.myapp.domain.PlaneTicket;
import com.mypackage.myapp.service.PlaneTicketService;

@Controller
@SessionAttributes
public class PlaneTicketsBookController {

	
	@Autowired
	PlaneTicketService planeTicketService;
	
	@RequestMapping("/planeTicketsListBook")
	public String listPlaneTicketsBook(Map<String, Object> map, HttpServletRequest request) {

		int planeTicketId = ServletRequestUtils.getIntParameter(request, "planeTicketId", -1);

		if (planeTicketId > 0)
			map.put("planeTicket", planeTicketService.getPlaneTicket(planeTicketId));
		else
			map.put("planeTicket", new PlaneTicket());

		map.put("planeTicketList", planeTicketService.listPlaneTicket());

		return "planeTicketsListBook";
	}
	

}
