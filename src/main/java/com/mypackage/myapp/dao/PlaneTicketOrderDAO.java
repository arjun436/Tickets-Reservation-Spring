package com.mypackage.myapp.dao;

import java.util.List;

import com.mypackage.myapp.domain.PlaneTicketOrder;

public interface PlaneTicketOrderDAO {

	public void addPlaneTicketOrder(PlaneTicketOrder planeTicketOrder);

	public List<PlaneTicketOrder> listPlaneTicketOrder();
	
	public void removePlaneTicketOrder(int id);

	public PlaneTicketOrder getPlaneTicketOrder(int id);

	public void editPlaneTicketOrder(PlaneTicketOrder planeTicketOrder);
	
}
