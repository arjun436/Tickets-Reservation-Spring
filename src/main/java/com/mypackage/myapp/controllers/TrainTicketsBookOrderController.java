package com.mypackage.myapp.controllers;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mypackage.myapp.domain.PlaneTicket;
import com.mypackage.myapp.domain.PlaneTicketOrder;
import com.mypackage.myapp.domain.TrainTicket;
import com.mypackage.myapp.domain.TrainTicketOrder;
import com.mypackage.myapp.domain.User;
import com.mypackage.myapp.service.TrainTicketOrderService;
import com.mypackage.myapp.service.TrainTicketService;
import com.mypackage.myapp.service.UserService;

@Controller
@SessionAttributes
public class TrainTicketsBookOrderController {

	
	@Autowired
	TrainTicketService trainTicketService;

	@Autowired
	TrainTicketOrderService trainTicketOrderService;

	@Autowired
	UserService userService;
	
	@RequestMapping("/trainTicketsListBookOrder")
	public String listTrainTicketsBookOrder(Map<String, Object> map, HttpServletRequest request, HttpSession sessionObj) {

		Integer trainTicketId = ServletRequestUtils.getIntParameter(request, "trainTicketId", -1);

		
		TrainTicket trainTicket = new TrainTicket();
		trainTicket = trainTicketService.getTrainTicket(trainTicketId);
		
		TrainTicketOrder trainTicketOrder = new TrainTicketOrder();
//		trainTicketOrder.setTrainTicketId(trainTicketId.toString());
		
		sessionObj.setAttribute("trainTicket" , trainTicket);

		//dane usera by wyplelnic automatycznie formularz
		try {
			Integer currentUserId = userService
					.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
			if (currentUserId != null) {

				User currentUser = userService.getUser(currentUserId);
				System.out.println(currentUser.getFirstname());
				map.put("currentUser", currentUser);

			}
		} catch (NullPointerException e) {
			System.out.println("no logged user");
		}
		
		
		
		
		
		
		map.put("trainTicketOrder", trainTicketOrder);

		map.put("trainTicketOrderList", trainTicketOrderService.listTrainTicketOrder());

		return "trainTicketsListBookOrder";
	}

	@RequestMapping(value = "/addTrainTicketOrder", method = (RequestMethod.POST)) // po
	public String addTrainTicketOrder(@ModelAttribute("trainTicketOrder") TrainTicketOrder trainTicketOrder,
			BindingResult result, HttpServletRequest request, Map<String, Object> map, HttpSession sessionObj) {// przyjmujemy

		TrainTicket trainTicket = (TrainTicket) sessionObj.getAttribute("trainTicket");

		trainTicketOrder.setTrainTicket(trainTicket);

		trainTicketOrderService.addTrainTicketOrder(trainTicketOrder);

		try {
			Integer currentUserId = userService
					.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
			if (currentUserId != null) {

				User currentUser = userService.getUser(currentUserId);

				Set<TrainTicketOrder> currentUserOrders = currentUser.getTrainTicketOrder();
				currentUserOrders.add(trainTicketOrder);
				currentUser.setTrainTicketOrder(currentUserOrders);

				userService.editUser(currentUser);

			}
		} catch (NullPointerException e) {
			System.out.println("no logged user");
		}

		return "redirect:http://localhost:8080/myapp/";

	}
}
