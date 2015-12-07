package com.mypackage.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypackage.myapp.dao.PlaneTicketOrderDAO;
import com.mypackage.myapp.domain.PlaneTicketOrder;

@Service
@Transactional
public class PlaneTicketOrderServiceImpl implements PlaneTicketOrderService{

	@Autowired
	PlaneTicketOrderDAO planeTicketOrderDAO;
	
	@Transactional
	public void addPlaneTicketOrder(PlaneTicketOrder planeTicketOrder) {
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
