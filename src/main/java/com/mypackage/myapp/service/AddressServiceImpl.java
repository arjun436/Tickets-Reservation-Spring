package com.mypackage.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypackage.myapp.dao.AddressDAO;
import com.mypackage.myapp.domain.Address;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressDAO addressDAO;

	@Transactional
	public void addAddress(Address address) {
		addressDAO.addAddress(address);

	}

	@Transactional
	public void editAddress(Address address) {
		addressDAO.editAddress(address);
	}

	@Transactional
	public List<Address> listAddress() {
		return addressDAO.listAddress();
	}

	@Transactional
	public void removeAddress(int id) {
		addressDAO.removeAddress(id);

	}

	@Transactional
	public Address getAddress(int id) {
		return addressDAO.getAddress(id);
	}

}
