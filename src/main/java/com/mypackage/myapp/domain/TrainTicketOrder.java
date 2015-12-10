package com.mypackage.myapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trainTicketOrder")
public class TrainTicketOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // strategia pola
	int id;

	// @Column(name = "firstname", nullable = false) // nie moze byc nullem
	private String firstname;
	private String secondname;
	private String lastname;
	private String state;
	private String city;
	private String street;
	private String email;
	private String telephone;

	@ManyToOne
	private TrainTicket trainTicket;

	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public TrainTicket getTrainTicket() {
		return trainTicket;
	}

	public void setTrainTicket(TrainTicket trainTicket) {
		this.trainTicket = trainTicket;
	}

}
