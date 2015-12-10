package com.mypackage.myapp.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mypackage.myapp.domain.TrainTicketOrder;
import com.mypackage.myapp.domain.User;
import com.mypackage.myapp.service.TrainTicketOrderService;
import com.mypackage.myapp.service.UserService;

@Controller
@SessionAttributes
public class TrainOrdersListController {

	
	@Autowired
	TrainTicketOrderService trainTicketOrderService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/trainOrdersList")
	public String listTrainOrders(Map<String, Object> map, HttpServletRequest request) {

		int trainOrderId = ServletRequestUtils.getIntParameter(request, "trainOrderId", -1);

		if (trainOrderId > 0)
			map.put("trainTicketOrder", trainTicketOrderService.getTrainTicketOrder(trainOrderId));
		else
			map.put("trainTicketOrder", new TrainTicketOrder());

		map.put("trainOrderList", trainTicketOrderService.listTrainTicketOrder());

		return "trainOrdersList";
	}
	@RequestMapping(value = "/deleteTrainOrder/{trainOrderId}", method = ( RequestMethod.GET))
	public String deleteTrainOrder(@PathVariable("trainOrderId") Integer trainOrderId) {
		trainTicketOrderService.removeTrainTicketOrder(trainOrderId);

		return "redirect:/trainOrdersList.html";
	}
	
	@RequestMapping("/myTrainOrders")
	public String listMyPlaneOrders(Map<String, Object> map, HttpServletRequest request) {


		try{
			Integer currentUserId = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
			if(currentUserId != null){
				User currentUser = userService.getUser(currentUserId);
				
				
				
				map.put("trainOrderList", currentUser.getTrainTicketOrder());

				
			}
		}catch(NullPointerException e){
			System.out.println("no logged user");
		}		
		

		return "myTrainOrders";
	}
	
}
