package com.mypackage.myapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypackage.myapp.domain.PlaneTicketOrder;
import com.mypackage.myapp.domain.TrainTicketOrder;


@Repository
public class TrainTicketOrderDAOImpl implements TrainTicketOrderDAO{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addTrainTicketOrder(TrainTicketOrder trainTicketOrder) {
		sessionFactory.getCurrentSession().save(trainTicketOrder);
		
	}

	@Override
	public List<TrainTicketOrder> listTrainTicketOrder() {
		return sessionFactory.getCurrentSession().createQuery("from TrainTicketOrder order by id").list();

	}

	@Override
	public void removeTrainTicketOrder(int id) {
		TrainTicketOrder trainTicketOrder = (TrainTicketOrder) sessionFactory.getCurrentSession().load(TrainTicketOrder.class, id);
		if (null != trainTicketOrder) {
			sessionFactory.getCurrentSession().delete(trainTicketOrder);
		}			
	}

	@Override
	public TrainTicketOrder getTrainTicketOrder(int id) {
		return (TrainTicketOrder) sessionFactory.getCurrentSession().get(TrainTicketOrder.class, id);

	}

	@Override
	public void editTrainTicketOrder(TrainTicketOrder trainTicketOrder) {
		sessionFactory.getCurrentSession().update(trainTicketOrder);
		
	}
	


}
