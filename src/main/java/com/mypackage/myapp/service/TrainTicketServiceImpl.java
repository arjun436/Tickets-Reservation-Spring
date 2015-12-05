package com.mypackage.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypackage.myapp.dao.TrainTicketDAO;
import com.mypackage.myapp.domain.TrainTicket;


@Service
@Transactional
public class TrainTicketServiceImpl implements TrainTicketService{

	@Autowired
	TrainTicketDAO trainTicketDAO;
	
	@Transactional
	public void addTrainTicket(TrainTicket trainTicket) {
		trainTicketDAO.addTrainTicket(trainTicket);
		
	}

	@Transactional
	public void editTrainTicket(TrainTicket trainTicket) {
		trainTicketDAO.editTrainTicket(trainTicket);
		
	}

	@Transactional
	public List<TrainTicket> listTrainTicket() {
		return trainTicketDAO.listTrainTicket();

	}

	@Transactional
	public void removeTrainTicket(int id) {
		trainTicketDAO.removeTrainTicket(id);
		
	}

	@Transactional
	public TrainTicket getTrainTicket(int id) {
		return trainTicketDAO.getTrainTicket(id);

	}

}
