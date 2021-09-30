package com.demo.flight.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Flight {
	@Id
	private int flightNo;
	private String airline;
	private String fromPlace;
	private String toPlace;
	private String startDate;
	private String endDate;
	private String scheduledDay;
	private String instrumentUsed;
	private String totBusinessClassSeat;
	private int ticketCost;
	private String status;
	public Flight(int flightNo, String airline, String fromPlace, String toPlace, String startDate, String endDate,
			String scheduledDay, String instrumentUsed, String totBusinessClassSeat, int ticketCost,String status) {
		super();
		this.flightNo = flightNo;
		this.airline = airline;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.startDate = startDate;
		this.endDate = endDate;
		this.scheduledDay = scheduledDay;
		this.instrumentUsed = instrumentUsed;
		this.totBusinessClassSeat = totBusinessClassSeat;
		this.ticketCost = ticketCost;
		this.status=status;
	}
	public Flight() {}
	
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getScheduledDay() {
		return scheduledDay;
	}
	public void setScheduledDay(String scheduledDay) {
		this.scheduledDay = scheduledDay;
	}
	public String getInstrumentUsed() {
		return instrumentUsed;
	}
	public void setInstrumentUsed(String instrumentUsed) {
		this.instrumentUsed = instrumentUsed;
	}
	public String getTotBusinessClassSeat() {
		return totBusinessClassSeat;
	}
	public void setTotBusinessClassSeat(String totBusinessClassSeat) {
		this.totBusinessClassSeat = totBusinessClassSeat;
	}
	public int getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(int ticketCost) {
		this.ticketCost = ticketCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	@Override
	public String toString() {
		return "Flight [flightNo=" + flightNo + ", airline=" + airline + ", fromPlace=" + fromPlace + ", toPlace="
				+ toPlace + ", startDate=" + startDate + ", endDate=" + endDate + ", scheduledDay=" + scheduledDay
				+ ", instrumentUsed=" + instrumentUsed + ", totBusinessClassSeat=" + totBusinessClassSeat
				+ ", ticketCost=" + ticketCost + ", status=" + status + "]";
	}
	
		
}

