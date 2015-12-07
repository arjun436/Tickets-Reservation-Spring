package com.mypackage.myapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypackage.myapp.domain.PlaneTicket;
import com.mypackage.myapp.domain.PlaneTicketOrder;

@Repository
public class PlaneTicketOrderDAOImpl implements PlaneTicketOrderDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addPlaneTicketOrder(PlaneTicketOrder planeTicketOrder) {
		sessionFactory.getCurrentSession().save(planeTicketOrder);
		
	}

	@Override
	public List<PlaneTicketOrder> listPlaneTicketOrder() {
		return sessionFactory.getCurrentSession().createQuery("from PlaneTicketOrder order by id").list();

	}

	@Override
	public void removePlaneTicketOrder(int id) {
		PlaneTicketOrder planeTicketOrder = (PlaneTicketOrder) sessionFactory.getCurrentSession().load(PlaneTicketOrder.class, id);
		if (null != planeTicketOrder) {
			sessionFactory.getCurrentSession().delete(planeTicketOrder);
		}		
	}

	@Override
	public PlaneTicketOrder getPlaneTicketOrder(int id) {
		return (PlaneTicketOrder) sessionFactory.getCurrentSession().get(PlaneTicketOrder.class, id);

	}

	@Override
	public void editPlaneTicketOrder(PlaneTicketOrder planeTicketOrder) {
		sessionFactory.getCurrentSession().update(planeTicketOrder);
		
	}

}
