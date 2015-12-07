package com.mypackage.myapp.service;

import java.util.List;

import com.mypackage.myapp.domain.PlaneTicketOrder;

public interface PlaneTicketOrderService {

	
	public void addPlaneTicketOrder(PlaneTicketOrder planeTicketOrder);

	public void editPlaneTicketOrder(PlaneTicketOrder planeTicketOrder);

	public List<PlaneTicketOrder> listPlaneTicketOrder();

	public void removePlaneTicketOrder(int id);

	public PlaneTicketOrder getPlaneTicketOrder(int id);
	
}
