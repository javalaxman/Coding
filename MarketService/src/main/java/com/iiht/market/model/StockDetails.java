package com.iiht.market.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK_DETAILS")
public class StockDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stockId;
	private int compnyCode;
	private double stockValue;
	private Date stockDate;
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public int getCompnyCode() {
		return compnyCode;
	}
	public void setCompnyCode(int compnyCode) {
		this.compnyCode = compnyCode;
	}
	public double getStockValue() {
		return stockValue;
	}
	public void setStockValue(double stockValue) {
		this.stockValue = stockValue;
	}
	public Date getStockDate() {
		return stockDate;
	}
	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", compnyCode=" + compnyCode + ", stockValue=" + stockValue
				+ ", stockDate=" + stockDate + "]";
	}
	public StockDetails(int stockId, int compnyCode, double stockValue, Date stockDate) {
		super();
		this.stockId = stockId;
		this.compnyCode = compnyCode;
		this.stockValue = stockValue;
		this.stockDate = stockDate;
	}
	public StockDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
