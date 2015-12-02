package com.mypackage.myapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypackage.myapp.domain.PlaneTicket;

@Repository
public class PlaneTicketDAOImpl implements PlaneTicketDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addPlaneTicket(PlaneTicket planeTicket) {
		sessionFactory.getCurrentSession().save(planeTicket);
		
	}

	@Override
	public List<PlaneTicket> listPlaneTicket() {
		return sessionFactory.getCurrentSession().createQuery("from PlaneTicket order by id").list();

	}

	@Override
	public void removePlaneTicket(int id) {
		PlaneTicket planeTicket = (PlaneTicket) sessionFactory.getCurrentSession().load(PlaneTicket.class, id);
		if (null != planeTicket) {
			sessionFactory.getCurrentSession().delete(planeTicket);
		}		
	}

	@Override
	public PlaneTicket getPlaneTicket(int id) {
		return (PlaneTicket) sessionFactory.getCurrentSession().get(PlaneTicket.class, id);

	}

	@Override
	public void editPlaneTicket(PlaneTicket planeTicket) {
		sessionFactory.getCurrentSession().update(planeTicket);
		
	}

}
