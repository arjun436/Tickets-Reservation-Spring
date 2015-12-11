package com.mypackage.myapp.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mypackage.myapp.domain.PlaneTicketOrder;
import com.mypackage.myapp.domain.User;
import com.mypackage.myapp.service.PlaneTicketOrderService;
import com.mypackage.myapp.service.PlaneTicketService;
import com.mypackage.myapp.service.UserService;

@Controller
@SessionAttributes
public class PlaneTicketsListController {

	@Autowired
	UserService userService;

	@Autowired
	PlaneTicketService planeTicketService;

	@Autowired
	PlaneTicketOrderService planeTicketOrderService;

	@RequestMapping("/planeTicketsList")
	public String listPlaneTickets(Map<String, Object> map, HttpServletRequest request) {

		// int planeTicketId = ServletRequestUtils.getIntParameter(request,
		// "planeTicketId", -1);
		//
		// if (planeTicketId > 0)
		// map.put("planeTicket",
		// planeTicketService.getPlaneTicket(planeTicketId));
		// else
		// map.put("planeTicket", new PlaneTicket());

		map.put("planeTicketList", planeTicketService.listPlaneTicket());

		return "planeTicketsList";
	}

	@RequestMapping(value = "/deletePlaneTicket/{planeTicketId}", method = (RequestMethod.GET))
	public String deletePlaneTicket(@PathVariable("planeTicketId") Integer planeTicketId) {

		// delete for users
		List<User> usersList = userService.listUser();

		for (Iterator it = usersList.iterator(); it.hasNext();) {
			User candidate = (User) it.next();
			List<PlaneTicketOrder> planeTicketOrderList = new ArrayList<PlaneTicketOrder>(
					candidate.getPlaneTicketOrder());

			for (Iterator it2 = planeTicketOrderList.iterator(); it2.hasNext();) {
				PlaneTicketOrder planeTicketOrder = (PlaneTicketOrder) it2.next();

				if (planeTicketOrder.getPlaneTicket().getId() == planeTicketId) {
					it2.remove();
					Set<PlaneTicketOrder> set = new HashSet<PlaneTicketOrder>(planeTicketOrderList);
					candidate.setPlaneTicketOrder(set);
					userService.editUser(candidate);
				}

			}
		}

		// delete orders with no users
		List<PlaneTicketOrder> planeTicketOrderList2 = new ArrayList<PlaneTicketOrder>(
				planeTicketOrderService.listPlaneTicketOrder());

		for (Iterator it3 = planeTicketOrderList2.iterator(); it3.hasNext();) {
			PlaneTicketOrder planeTicketOrder2 = (PlaneTicketOrder) it3.next();

			if (planeTicketOrder2.getPlaneTicket().getId() == planeTicketId) {

				planeTicketOrderService.removePlaneTicketOrder(planeTicketOrder2.getId());

			}

		}

		// delete ticket
		planeTicketService.removePlaneTicket(planeTicketId);

		return "redirect:/planeTicketsList.html";
	}

}
