package com.mypackage.myapp.service;

import java.util.List;

import com.mypackage.myapp.domain.TrainTicketOrder;

public interface TrainTicketOrderService {

	
	public void addTrainTicketOrder(TrainTicketOrder trainTicketOrder);

	public void editTrainTicketOrder(TrainTicketOrder trainTicketOrder);

	public List<TrainTicketOrder> listTrainTicketOrder();

	public void removeTrainTicketOrder(int id);

	public TrainTicketOrder getTrainTicketOrder(int id);
	
}
