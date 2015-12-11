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
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mypackage.myapp.domain.PlaneTicketOrder;
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

	@RequestMapping(value = "/deleteTrainOrder/{trainOrderId}", method = (RequestMethod.GET))
	public String deleteTrainOrder(@PathVariable("trainOrderId") Integer trainOrderId) {
		
		
		
		// delete order for users
		List<User> usersList = userService.listUser();

		for (Iterator it = usersList.iterator(); it.hasNext();) {
			User candidate = (User) it.next();
			List<TrainTicketOrder> trainTicketOrderList = new ArrayList<TrainTicketOrder>(
					candidate.getTrainTicketOrder());

			for (Iterator it2 = trainTicketOrderList.iterator(); it2.hasNext();) {
				TrainTicketOrder trainTicketOrder = (TrainTicketOrder) it2.next();

				if (trainTicketOrder.getId() == trainOrderId) {
					it2.remove();
					Set<TrainTicketOrder> set = new HashSet<TrainTicketOrder>(trainTicketOrderList);
					candidate.setTrainTicketOrder(set);
					userService.editUser(candidate);
				}

			}
		}

		// deleter order
		trainTicketOrderService.removeTrainTicketOrder(trainOrderId);
		
		
		return "redirect:/trainOrdersList.html";
	}

	@RequestMapping("/myTrainOrders")
	public String listMyPlaneOrders(Map<String, Object> map, HttpServletRequest request) {

		try {
			Integer currentUserId = userService
					.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
			if (currentUserId != null) {
				User currentUser = userService.getUser(currentUserId);

				map.put("trainOrderList", currentUser.getTrainTicketOrder());

			}
		} catch (NullPointerException e) {
			System.out.println("no logged user");
		}

		return "myTrainOrders";
	}

}
