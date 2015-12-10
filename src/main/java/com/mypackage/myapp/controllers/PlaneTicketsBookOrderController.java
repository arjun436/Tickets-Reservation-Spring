package com.mypackage.myapp.controllers;

import java.util.HashSet;
import java.util.List;
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
import com.mypackage.myapp.domain.User;
import com.mypackage.myapp.service.PlaneTicketOrderService;
import com.mypackage.myapp.service.PlaneTicketService;
import com.mypackage.myapp.service.UserService;

@Controller
@SessionAttributes
public class PlaneTicketsBookOrderController {

	@Autowired
	PlaneTicketService planeTicketService;

	@Autowired
	PlaneTicketOrderService planeTicketOrderService;
	
	@Autowired
	UserService userService;

	@RequestMapping("/planeTicketsListBookOrder")
	public String listPlaneTicketsBookOrder(Map<String, Object> map, HttpServletRequest request, HttpSession sessio, HttpSession sessionObj) {

		Integer planeTicketId = ServletRequestUtils.getIntParameter(request, "planeTicketId", -1);

		PlaneTicket planeTicket = new PlaneTicket();
		planeTicket = planeTicketService.getPlaneTicket(planeTicketId);
		
		PlaneTicketOrder planeTicketOrder = new PlaneTicketOrder();
//		planeTicketOrder.setPlaneTicketId(planeTicketId.toString());
		
		sessionObj.setAttribute("planeTicket" , planeTicket);

		map.put("planeTicketOrder", planeTicketOrder);

		map.put("planeTicketOrderList", planeTicketOrderService.listPlaneTicketOrder());

		return "planeTicketsListBookOrder";
	}

	@RequestMapping(value = "/addPlaneTicketOrder", method = (RequestMethod.POST)) // po
	public String addPlaneTicketOrder(@ModelAttribute("planeTicketOrder") PlaneTicketOrder planeTicketOrder,
			BindingResult result, HttpServletRequest request, Map<String, Object> map, HttpSession sessionObj) {// przyjmujemy

		
		
		PlaneTicket planeTicket = (PlaneTicket)sessionObj.getAttribute("planeTicket");
		
		
		planeTicketOrder.setPlaneTicket(planeTicket);

		
		planeTicketOrderService.addPlaneTicketOrder(planeTicketOrder);

		
		
		
		
		
		try{
			Integer currentUserId = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
			if(currentUserId != null){
				
				
				User currentUser = userService.getUser(currentUserId);

				Set<PlaneTicketOrder> currentUserOrders = currentUser.getPlaneTicketOrder();
				currentUserOrders.add(planeTicketOrder);
				currentUser.setPlaneTicketOrder(currentUserOrders);

				userService.editUser(currentUser);
				
				
//				System.out.println(planeTicket.getId());
//				//zaktualizowanie planeticktow jakie posiada user
//				Set<PlaneTicket> planeTickets = currentUser.getPlaneTicket();
//				planeTickets.add(planeTicket);				
//				currentUser.setPlaneTicket(planeTickets);
//				planeTicketService.getPlaneTicket(planeTicket.getId()).setUser(currentUser);
//				
//				//zapisanie w orderze usera
//				planeTicketOrder.setUser(currentUser);
				
				
				
			}
		}catch(NullPointerException e){
			System.out.println("no logged user");
		}
		
		
		
//		Integer planeTicketId = Integer.parseInt(planeTicketOrder.getPlaneTicketId());
//		planeTicketOrder.setPlaneTicket(planeTicketService.getPlaneTicket(planeTicketId));
//		Set<PlaneTicket> planeTickets = planeTicketOrder.getPlaneTicket();
//		planeTickets.add(planeTicket);
//		planeTicketOrder.setPlaneTicket(planeTickets);


		return "redirect:http://localhost:8080/myapp/";

	}

}
