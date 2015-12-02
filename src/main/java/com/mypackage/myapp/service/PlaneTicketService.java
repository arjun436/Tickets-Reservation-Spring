package com.mypackage.myapp.service;

import java.util.List;

import com.mypackage.myapp.domain.PlaneTicket;

public interface PlaneTicketService {

	public void addPlaneTicket(PlaneTicket planeTicket);

	public void editPlaneTicket(PlaneTicket planeTicket);

	public List<PlaneTicket> listPlaneTicket();

	public void removePlaneTicket(int id);

	public PlaneTicket getPlaneTicket(int id);



}
