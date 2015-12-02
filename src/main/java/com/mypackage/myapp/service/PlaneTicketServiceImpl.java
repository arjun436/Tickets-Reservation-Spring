package com.mypackage.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypackage.myapp.dao.PlaneTicketDAO;
import com.mypackage.myapp.domain.PlaneTicket;

@Service
@Transactional
public class PlaneTicketServiceImpl implements PlaneTicketService {

	@Autowired
	PlaneTicketDAO planeTicketDAO;

	@Transactional
	public void addPlaneTicket(PlaneTicket planeTicket) {

		planeTicketDAO.addPlaneTicket(planeTicket);
	}

	@Transactional
	public void editPlaneTicket(PlaneTicket planeTicket) {
		planeTicketDAO.editPlaneTicket(planeTicket);
	}

	@Transactional
	public List<PlaneTicket> listPlaneTicket() {
		return planeTicketDAO.listPlaneTicket();

	}

	@Transactional
	public void removePlaneTicket(int id) {
		planeTicketDAO.removePlaneTicket(id);
	}

	@Transactional
	public PlaneTicket getPlaneTicket(int id) {
		return planeTicketDAO.getPlaneTicket(id);

	}

}
