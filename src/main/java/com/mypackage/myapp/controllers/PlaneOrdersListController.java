package com.mypackage.myapp.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mypackage.myapp.domain.PlaneTicketOrder;
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
		
		
		
		
		
				//delete order for users
				List<User> usersList = userService.listUser();
				
		        for (Iterator it = usersList.iterator(); it.hasNext();) {
		            User candidate = (User)it.next();
		            System.out.println(candidate.getLogin());
		    		List<PlaneTicketOrder> planeTicketOrderList =  new ArrayList<PlaneTicketOrder>(candidate.getPlaneTicketOrder());

		    		
		            for (Iterator it2 = planeTicketOrderList.iterator();it2.hasNext();){
		            		PlaneTicketOrder planeTicketOrder = (PlaneTicketOrder)it2.next();
		                    System.out.println(planeTicketOrder.getPlaneTicket().getFlightNumber());

		            		if(planeTicketOrder.getId() == planeOrderId){
		            			it2.remove();
		            			Set<PlaneTicketOrder> set = new HashSet<PlaneTicketOrder>(planeTicketOrderList);
		            			candidate.setPlaneTicketOrder(set);
		            			userService.editUser(candidate);
		            		}

		            }
		          }
		        
		        //deleter order
    			planeTicketOrderService.removePlaneTicketOrder(planeOrderId);




		
		
		
		
		
		
		
		

		return "redirect:/planeOrdersList.html";
	}
	
	@RequestMapping("/myPlaneOrders")
	public String listMyPlaneOrders(Map<String, Object> map, HttpServletRequest request) {


		try{
			Integer currentUserId = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
			if(currentUserId != null){
				User currentUser = userService.getUser(currentUserId);
				
				
				
				map.put("planeOrderList", currentUser.getPlaneTicketOrder());

				
			}
		}catch(NullPointerException e){
			System.out.println("no logged user");
		}		
		

		return "myPlaneOrders";
	}
	
}
