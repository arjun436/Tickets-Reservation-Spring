package com.mypackage.myapp.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mypackage.myapp.domain.User;
import com.mypackage.myapp.service.PlaneTicketOrderService;
import com.mypackage.myapp.service.UserService;


@Controller
@SessionAttributes
public class PlaneOrdersListController {
	
	
	@Autowired
	PlaneTicketOrderService planeTicketOrderService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/planeOrdersList")
	public String listPlaneOrders(Map<String, Object> map, HttpServletRequest request) {

//		int planeOrderId = ServletRequestUtils.getIntParameter(request, "planeOrderId", -1);
//
//		if (planeOrderId > 0)
//			map.put("planeTicketOrder", planeTicketOrderService.getPlaneTicketOrder(planeOrderId));
//		else
//			map.put("planeTicketOrder", new PlaneTicketOrder());

		map.put("planeOrderList", planeTicketOrderService.listPlaneTicketOrder());

		return "planeOrdersList";
	}
	@RequestMapping(value = "/deletePlaneOrder/{planeOrderId}", method = ( RequestMethod.GET))
	public String deletePlaneOrder(@PathVariable("planeOrderId") Integer planeOrderId) {
		planeTicketOrderService.removePlaneTicketOrder(planeOrderId);

		return "redirect:/planeOrdersList.html";
	}
	
	@RequestMapping("/myPlaneOrders")
	public String listMyPlaneOrders(Map<String, Object> map, HttpServletRequest request) {

//		int planeOrderId = ServletRequestUtils.getIntParameter(request, "planeOrderId", -1);
//
//		if (planeOrderId > 0)
//			map.put("planeTicketOrder", planeTicketOrderService.getPlaneTicketOrder(planeOrderId));
//		else
//			map.put("planeTicketOrder", new PlaneTicketOrder());
		
//		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//	      Authentication auth = SecurityContextHolder.getContext().getAuthentication().getName()
////	      User customUser = (User)auth.getPrincipal();
//	      user.getAuthorities()
//	      System.out.println(userId);
//	      userService.getUser(userId);
		try{
			Integer currentUserId = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
			if(currentUserId != null){
				User currentUser = userService.getUser(currentUserId);
				
				map.put("planeOrderList", currentUser.getUserPlaneTicket());

				
			}
		}catch(NullPointerException e){
			System.out.println("no logged user");
		}		
		

		return "myPlaneOrders";
	}
	
}
