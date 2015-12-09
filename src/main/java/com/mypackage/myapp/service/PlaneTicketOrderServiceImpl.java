package com.mypackage.myapp.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypackage.myapp.dao.PlaneTicketOrderDAO;
import com.mypackage.myapp.dao.UserDAOImpl;
import com.mypackage.myapp.domain.PlaneTicket;
import com.mypackage.myapp.domain.PlaneTicketOrder;
import com.mypackage.myapp.domain.User;

@Service
@Transactional
public class PlaneTicketOrderServiceImpl implements PlaneTicketOrderService{

	@Autowired
	PlaneTicketOrderDAO planeTicketOrderDAO;
	
	@Autowired
	UserDAOImpl userDAOImpl;
	
	@Transactional
	public void addPlaneTicketOrder(PlaneTicketOrder planeTicketOrder) {
		
		try{
			Integer currentUserId = userDAOImpl.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
			if(currentUserId != null){
				User currentUser = userDAOImpl.getUser(currentUserId);
				Set<PlaneTicket> userPlaneTicket = currentUser.getUserPlaneTicket();
				userPlaneTicket.add(planeTicketOrder.getPlaneTicket());
				currentUser.setUserPlaneTicket(userPlaneTicket);
			}
		}catch(NullPointerException e){
			System.out.println("no logged user");
		}


		planeTicketOrderDAO.addPlaneTicketOrder(planeTicketOrder);
		
	}

	@Transactional
	public void editPlaneTicketOrder(PlaneTicketOrder planeTicketOrder) {
		planeTicketOrderDAO.editPlaneTicketOrder(planeTicketOrder);
		
	}

	@Transactional
	public List<PlaneTicketOrder> listPlaneTicketOrder() {
		return planeTicketOrderDAO.listPlaneTicketOrder();

	}

	@Transactional
	public void removePlaneTicketOrder(int id) {
		planeTicketOrderDAO.removePlaneTicketOrder(id);
		
	}

	@Transactional
	public PlaneTicketOrder getPlaneTicketOrder(int id) {
		return planeTicketOrderDAO.getPlaneTicketOrder(id);

	}

}
