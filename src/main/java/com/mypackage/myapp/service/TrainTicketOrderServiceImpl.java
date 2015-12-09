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
		
		try{
			Integer currentUserId = userDAOImpl.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
			if(currentUserId != null){
				User currentUser = userDAOImpl.getUser(currentUserId);
				Set<TrainTicket> userTrainTicket = currentUser.getUserTrainTicket();
				userTrainTicket.add(trainTicketOrder.getTrainTicket());
				currentUser.setUserTrainTicket(userTrainTicket);
			}
		}catch(NullPointerException e){
			System.out.println("no logged user");
		}
		
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
