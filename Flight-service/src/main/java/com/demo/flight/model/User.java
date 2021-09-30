package com.demo.flight.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {

	  @Id 
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long id;
	  private String name;
	  private String email;
	  private int noOfSeatToBook;
	  private char gender;
	  private String optMeal;
	  private int seatNumber;
	  private String pnr;
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNoOfSeatToBook() {
		return noOfSeatToBook;
	}
	public void setNoOfSeatToBook(int noOfSeatToBook) {
		this.noOfSeatToBook = noOfSeatToBook;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getOptMeal() {
		return optMeal;
	}
	public void setOptMeal(String optMeal) {
		this.optMeal = optMeal;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public User(Long id, String name, String email, int noOfSeatToBook, char gender, String optMeal, int seatNumber,String pnr) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.noOfSeatToBook = noOfSeatToBook;
		this.gender = gender;
		this.optMeal = optMeal;
		this.seatNumber = seatNumber;
		this.pnr=pnr;
	}
	public User() {}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", noOfSeatToBook=" + noOfSeatToBook
				+ ", gender=" + gender + ", optMeal=" + optMeal + ", seatNumber=" + seatNumber + ",pnr="+pnr+"]";
	}
	  
}
