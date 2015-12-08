package com.mypackage.myapp.dao;

import java.util.List;

import com.mypackage.myapp.domain.TrainTicketOrder;

public interface TrainTicketOrderDAO {

	
	public void addTrainTicketOrder(TrainTicketOrder trainTicketOrder);

	public List<TrainTicketOrder> listTrainTicketOrder();

	public void removeTrainTicketOrder(int id);

	public TrainTicketOrder getTrainTicketOrder(int id);

	public void editTrainTicketOrder(TrainTicketOrder trainTicketOrder);
}
