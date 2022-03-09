package com.iiht.market.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
public class CompnyDetails {
	
	public CompnyDetails(int compnyCode, String compnyName, String compnyCeo, String website, long turnOver,
			String stock, double stockValue, Date date) {
		super();
		this.compnyCode = compnyCode;
		this.compnyName = compnyName;
		this.compnyCeo = compnyCeo;
		this.website = website;
		this.turnOver = turnOver;
		this.stock = stock;
		this.stockValue = stockValue;
		this.date = date;
	}

	private int compnyCode;
	private String compnyName;
	private String compnyCeo;
	private String website;
	private long turnOver;
	private String stock;
	private double stockValue;
	private Date date;
	
	public CompnyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCompnyCode() {
		return compnyCode;
	}

	public void setCompnyCode(int compnyCode) {
		this.compnyCode = compnyCode;
	}

	public String getCompnyName() {
		return compnyName;
	}

	public void setCompnyName(String compnyName) {
		this.compnyName = compnyName;
	}

	public String getCompnyCeo() {
		return compnyCeo;
	}

	public void setCompnyCeo(String compnyCeo) {
		this.compnyCeo = compnyCeo;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public long getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(long turnOver) {
		this.turnOver = turnOver;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public double getStockValue() {
		return stockValue;
	}

	public void setStockValue(double stockValue) {
		this.stockValue = stockValue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CompnyDetails [compnyCode=" + compnyCode + ", compnyName=" + compnyName + ", compnyCeo=" + compnyCeo
				+ ", website=" + website + ", turnOver=" + turnOver + ", stock=" + stock + ", stockValue=" + stockValue
				+ ", date=" + date + "]";
	}

}
