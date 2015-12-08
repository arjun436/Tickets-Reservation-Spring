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

import com.mypackage.myapp.domain.TrainTicketOrder;
import com.mypackage.myapp.service.TrainTicketOrderService;

@Controller
@SessionAttributes
public class TrainOrdersListController {

	
	@Autowired
	TrainTicketOrderService trainTicketOrderService;
	
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
	
}
