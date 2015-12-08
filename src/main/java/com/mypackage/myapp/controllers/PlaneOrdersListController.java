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

import com.mypackage.myapp.domain.PlaneTicketOrder;
import com.mypackage.myapp.service.PlaneTicketOrderService;


@Controller
@SessionAttributes
public class PlaneOrdersListController {
	@Autowired
	PlaneTicketOrderService planeTicketOrderService;
	
	@RequestMapping("/planeOrdersList")
	public String listPlaneOrders(Map<String, Object> map, HttpServletRequest request) {

		int planeOrderId = ServletRequestUtils.getIntParameter(request, "planeOrderId", -1);

		if (planeOrderId > 0)
			map.put("planeTicketOrder", planeTicketOrderService.getPlaneTicketOrder(planeOrderId));
		else
			map.put("planeTicketOrder", new PlaneTicketOrder());

		map.put("planeOrderList", planeTicketOrderService.listPlaneTicketOrder());

		return "planeOrdersList";
	}
	@RequestMapping(value = "/deletePlaneOrder/{planeOrderId}", method = ( RequestMethod.GET))
	public String deletePlaneOrder(@PathVariable("planeOrderId") Integer planeOrderId) {
		planeTicketOrderService.removePlaneTicketOrder(planeOrderId);

		return "redirect:/planeOrdersList.html";
	}
	
	
	
}
