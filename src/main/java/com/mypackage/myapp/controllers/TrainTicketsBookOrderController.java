package com.mypackage.myapp.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mypackage.myapp.domain.TrainTicketOrder;
import com.mypackage.myapp.service.TrainTicketOrderService;
import com.mypackage.myapp.service.TrainTicketService;

@Controller
@SessionAttributes
public class TrainTicketsBookOrderController {

	
	@Autowired
	TrainTicketService trainTicketService;

	@Autowired
	TrainTicketOrderService trainTicketOrderService;

	@RequestMapping("/trainTicketsListBookOrder")
	public String listTrainTicketsBookOrder(Map<String, Object> map, HttpServletRequest request) {

		Integer trainTicketId = ServletRequestUtils.getIntParameter(request, "trainTicketId", -1);

		TrainTicketOrder trainTicketOrder = new TrainTicketOrder();
		trainTicketOrder.setTrainTicketId(trainTicketId.toString());
		
		map.put("trainTicketOrder", trainTicketOrder);

		map.put("trainTicketOrderList", trainTicketOrderService.listTrainTicketOrder());

		return "trainTicketsListBookOrder";
	}

	@RequestMapping(value = "/addTrainTicketOrder", method = (RequestMethod.POST)) // po
	public String addTrainTicketOrder(@ModelAttribute("trainTicketOrder") TrainTicketOrder trainTicketOrder,
			BindingResult result, HttpServletRequest request, Map<String, Object> map) {// przyjmujemy

		Integer trainTicketId = Integer.parseInt(trainTicketOrder.getTrainTicketId());
		trainTicketOrder.setTrainTicket(trainTicketService.getTrainTicket(trainTicketId));
		trainTicketOrderService.addTrainTicketOrder(trainTicketOrder);

		return "redirect:http://localhost:8080/myapp/";

	}
}
