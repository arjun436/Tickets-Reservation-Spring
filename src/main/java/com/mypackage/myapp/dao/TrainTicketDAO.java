package com.mypackage.myapp.dao;

import java.util.List;

import com.mypackage.myapp.domain.TrainTicket;

public interface TrainTicketDAO {

	
	public void addTrainTicket(TrainTicket trainTicket);

	public List<TrainTicket> listTrainTicket();

	public void removeTrainTicket(int id);

	public TrainTicket getTrainTicket(int id);

	public void editTrainTicket(TrainTicket trainTicket);
}
