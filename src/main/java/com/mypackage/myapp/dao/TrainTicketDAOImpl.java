package com.mypackage.myapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypackage.myapp.domain.TrainTicket;

@Repository
public class TrainTicketDAOImpl implements TrainTicketDAO{

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addTrainTicket(TrainTicket trainTicket) {
		sessionFactory.getCurrentSession().save(trainTicket);
		
	}

	@Override
	public List<TrainTicket> listTrainTicket() {
		return sessionFactory.getCurrentSession().createQuery("from TrainTicket order by id").list();

	}

	@Override
	public void removeTrainTicket(int id) {
		TrainTicket trainTicket = (TrainTicket) sessionFactory.getCurrentSession().load(TrainTicket.class, id);
		if (null != trainTicket) {
			sessionFactory.getCurrentSession().delete(trainTicket);
		}			
	}

	@Override
	public TrainTicket getTrainTicket(int id) {
		return (TrainTicket) sessionFactory.getCurrentSession().get(TrainTicket.class, id);

	}

	@Override
	public void editTrainTicket(TrainTicket trainTicket) {
		sessionFactory.getCurrentSession().update(trainTicket);
		
	}

}
