package com.mypackage.myapp.dao;

import java.util.List;

import com.mypackage.myapp.domain.PlaneTicket;

public interface PlaneTicketDAO {

	public void addPlaneTicket(PlaneTicket planeTicket);

	public List<PlaneTicket> listPlaneTicket();

	public void removePlaneTicket(int id);

	public PlaneTicket getPlaneTicket(int id);

	public void editPlaneTicket(PlaneTicket planeTicket);



}
