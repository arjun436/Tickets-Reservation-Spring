package com.mypackage.myapp.dao;

import java.util.List;

import com.mypackage.myapp.domain.Address;

public interface AddressDAO {

	
	public void addAddress(Address address);
	public List<Address> listAddress();
	public void removeAddress(int id);
	public Address getAddress(int id);
	public void editAddress(Address address);
	
}
