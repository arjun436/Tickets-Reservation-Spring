package com.mypackage.myapp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "trainTicket")
public class TrainTicket {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // strategia pola
	int id;

	//@Column(name = "firstname", nullable = false) // nie moze byc nullem
	private String transitNumber;
	private String transitName;
	private String transitFrom;
	private String transitTo;
	private String transitDateStart;
	private String transitHourStart;
	private String transitDateStop;
	private String transitHourStop;
	private String transitPrice;
	
	@OneToMany(mappedBy = "trainTicket")
	private List<TrainTicketOrder> trainTicketOrder;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTransitNumber() {
		return transitNumber;
	}
	public void setTransitNumber(String transitNumber) {
		this.transitNumber = transitNumber;
	}
	public String getTransitName() {
		return transitName;
	}
	public void setTransitName(String transitName) {
		this.transitName = transitName;
	}
	public String getTransitFrom() {
		return transitFrom;
	}
	public void setTransitFrom(String transitFrom) {
		this.transitFrom = transitFrom;
	}
	public String getTransitTo() {
		return transitTo;
	}
	public void setTransitTo(String transitTo) {
		this.transitTo = transitTo;
	}
	public String getTransitDateStart() {
		return transitDateStart;
	}
	public void setTransitDateStart(String transitDateStart) {
		this.transitDateStart = transitDateStart;
	}
	public String getTransitHourStart() {
		return transitHourStart;
	}
	public void setTransitHourStart(String transitHourStart) {
		this.transitHourStart = transitHourStart;
	}
	public String getTransitDateStop() {
		return transitDateStop;
	}
	public void setTransitDateStop(String transitDateStop) {
		this.transitDateStop = transitDateStop;
	}
	public String getTransitHourStop() {
		return transitHourStop;
	}
	public void setTransitHourStop(String transitHourStop) {
		this.transitHourStop = transitHourStop;
	}
	public String getTransitPrice() {
		return transitPrice;
	}
	public void setTransitPrice(String transitPrice) {
		this.transitPrice = transitPrice;
	}
	public List<TrainTicketOrder> getTrainTicketOrder() {
		return trainTicketOrder;
	}
	public void setTrainTicketOrder(List<TrainTicketOrder> trainTicketOrder) {
		this.trainTicketOrder = trainTicketOrder;
	}

}
