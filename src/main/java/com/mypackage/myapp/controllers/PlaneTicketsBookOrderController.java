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

import com.mypackage.myapp.domain.PlaneTicketOrder;
import com.mypackage.myapp.service.PlaneTicketOrderService;

@Controller
@SessionAttributes
public class PlaneTicketsBookOrderController {

	
	
	
	
	@Autowired
	PlaneTicketOrderService planeTicketOrderService;
	
	@RequestMapping("/planeTicketsListBookOrder")
	public String listPlaneTicketsBookOrder(Map<String, Object> map, HttpServletRequest request) {

		int planeTicketOrderId = ServletRequestUtils.getIntParameter(request, "planeTicketOrderId", -1);

		if (planeTicketOrderId > 0)
			map.put("planeTicketOrder", planeTicketOrderService.getPlaneTicketOrder(planeTicketOrderId));
		else
			map.put("planeTicketOrder", new PlaneTicketOrder());

		map.put("planeTicketOrderList", planeTicketOrderService.listPlaneTicketOrder());

		return "planeTicketsListBookOrder";
	}
	
	@RequestMapping(value = "/addPlaneTicketOrder", method = (RequestMethod.POST)) // po
	public String addPlaneTicketOrder(@ModelAttribute("planeTicketOrder") PlaneTicketOrder planeTicketOrder, BindingResult result,
			HttpServletRequest request, Map<String, Object> map) {// przyjmujemy

//		planeTicketOrderValidator.validate(planeTicketOrder, result);
		
		
//		if (result.getErrorCount() == 0) {
				
//				if (planeTicket.getId() == 0)
					planeTicketOrderService.addPlaneTicketOrder(planeTicketOrder);
//				else
//					planeTicketService.editPlaneTicket(planeTicket);



			return "redirect:http://localhost:8080/myapp/";// z tego kontrolera jestesmy
											// przekierowani na users.html
//		}
//		
//		
//
//		return "planeTicketsListBookOrder";
	}
	
}
