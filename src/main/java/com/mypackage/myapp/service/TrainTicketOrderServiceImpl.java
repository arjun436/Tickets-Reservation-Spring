package com.mypackage.myapp.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypackage.myapp.dao.TrainTicketOrderDAO;
import com.mypackage.myapp.dao.UserDAOImpl;
import com.mypackage.myapp.domain.TrainTicket;
import com.mypackage.myapp.domain.TrainTicketOrder;
import com.mypackage.myapp.domain.User;


@Service
@Transactional
public class TrainTicketOrderServiceImpl implements TrainTicketOrderService {

	@Autowired
	TrainTicketOrderDAO trainTicketOrderDAO;
	
	@Autowired
	UserDAOImpl userDAOImpl;
	
	@Transactional
	public void addTrainTicketOrder(TrainTicketOrder trainTicketOrder) {
		
		
		trainTicketOrderDAO.addTrainTicketOrder(trainTicketOrder);
		
	}

	@Transactional
	public void editTrainTicketOrder(TrainTicketOrder trainTicketOrder) {
		trainTicketOrderDAO.editTrainTicketOrder(trainTicketOrder);
		
	}

	@Transactional
	public List<TrainTicketOrder> listTrainTicketOrder() {
		return trainTicketOrderDAO.listTrainTicketOrder();

	}

	@Transactional
	public void removeTrainTicketOrder(int id) {
		trainTicketOrderDAO.removeTrainTicketOrder(id);
		
	}

	@Transactional
	public TrainTicketOrder getTrainTicketOrder(int id) {
		return trainTicketOrderDAO.getTrainTicketOrder(id);

	}

}
