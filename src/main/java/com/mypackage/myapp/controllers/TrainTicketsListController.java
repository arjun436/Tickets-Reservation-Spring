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
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mypackage.myapp.domain.TrainTicket;
import com.mypackage.myapp.domain.TrainTicketOrder;
import com.mypackage.myapp.domain.User;
import com.mypackage.myapp.service.TrainTicketOrderService;
import com.mypackage.myapp.service.TrainTicketService;
import com.mypackage.myapp.service.UserService;

@Controller
@SessionAttributes
public class TrainTicketsListController {

	@Autowired
	UserService userService;
	
	@Autowired
	TrainTicketOrderService trainTicketOrderService;
	
	@Autowired
	TrainTicketService trainTicketService;
	
	@RequestMapping("/trainTicketsList")
	public String listTrainTickets(Map<String, Object> map, HttpServletRequest request) {

		int trainTicketId = ServletRequestUtils.getIntParameter(request, "trainTicketId", -1);

		if (trainTicketId > 0)
			map.put("trainTicket", trainTicketService.getTrainTicket(trainTicketId));
		else
			map.put("trainTicket", new TrainTicket());

		map.put("trainTicketList", trainTicketService.listTrainTicket());

		return "trainTicketsList";
	}
	@RequestMapping(value = "/deleteTrainTicket/{trainTicketId}", method = ( RequestMethod.GET))
	public String deletePlaneTicket(@PathVariable("trainTicketId") Integer trainTicketId) {
		
		
		//delete for users
				List<User> usersList = userService.listUser();
				
		        for (Iterator it = usersList.iterator(); it.hasNext();) {
		            User candidate = (User)it.next();
		    		List<TrainTicketOrder> trainTicketOrderList =  new ArrayList<TrainTicketOrder>(candidate.getTrainTicketOrder());

		    		
		            for (Iterator it2 = trainTicketOrderList.iterator();it2.hasNext();){
		            		TrainTicketOrder trainTicketOrder = (TrainTicketOrder)it2.next();

		            		if(trainTicketOrder.getTrainTicket().getId() == trainTicketId){
		            			it2.remove();
		            			Set<TrainTicketOrder> set = new HashSet<TrainTicketOrder>(trainTicketOrderList);
		            			candidate.setTrainTicketOrder(set);
		            			userService.editUser(candidate);
		            		}
		            	
		            }
		          }
				
		        //delete orders with no users
				List<TrainTicketOrder> trainTicketOrderList2 =  new ArrayList<TrainTicketOrder>(trainTicketOrderService.listTrainTicketOrder());

		        for (Iterator it3 = trainTicketOrderList2.iterator();it3.hasNext();){
		        		TrainTicketOrder trainTicketOrder2 = (TrainTicketOrder)it3.next();

		        		if(trainTicketOrder2.getTrainTicket().getId() == trainTicketId){
		        		trainTicketOrderService.removeTrainTicketOrder(trainTicketOrder2.getId());

		        		}
		        	
		        }

		        //delete ticket 
				trainTicketService.removeTrainTicket(trainTicketId);
				
				
		return "redirect:/trainTicketsList.html";
	}
}
