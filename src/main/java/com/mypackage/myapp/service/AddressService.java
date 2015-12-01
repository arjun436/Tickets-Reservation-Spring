package com.mypackage.myapp.service;

import java.util.List;

import com.mypackage.myapp.domain.Address;

public interface AddressService {

	public void addAddress(Address address);

	public void editAddress(Address address);

	public List<Address> listAddress();

	public void removeAddress(int id);

	public Address getAddress(int id);
	
}
