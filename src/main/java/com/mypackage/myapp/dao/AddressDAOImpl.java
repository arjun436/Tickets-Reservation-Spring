package com.mypackage.myapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mypackage.myapp.domain.Address;

@Repository
public class AddressDAOImpl implements AddressDAO{

	
	@Autowired
	SessionFactory sessionFactory;
	
	public void addAddress(Address address) {
		sessionFactory.getCurrentSession().save(address);
	}

	public List<Address> listAddress() {
		return sessionFactory.getCurrentSession().createQuery("from Address order by id").list();
	}

	public void removeAddress(int id) {
		Address address = (Address) sessionFactory.getCurrentSession().load(Address.class, id);
		if(null!=address){
			sessionFactory.getCurrentSession().delete(address);;
		}
	}

	public Address getAddress(int id) {
		return (Address)sessionFactory.getCurrentSession().get(Address.class, id);
	}

	public void editAddress(Address address) {
		sessionFactory.getCurrentSession().update(address);
		
	}

}
