package com.mypackage.myapp.service;

import java.util.List;

import com.mypackage.myapp.domain.TrainTicket;

public interface TrainTicketService {
	
	public void addTrainTicket(TrainTicket trainTicket);

	public void editTrainTicket(TrainTicket trainTicket);

	public List<TrainTicket> listTrainTicket();

	public void removeTrainTicket(int id);

	public TrainTicket getTrainTicket(int id);
}
