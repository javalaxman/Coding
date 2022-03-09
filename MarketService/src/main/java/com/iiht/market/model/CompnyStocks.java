package com.iiht.market.model;

import java.util.List;

public class CompnyStocks {
	public CompnyStocks(int compnyCode, String compnyName, String compnyCeo, String website, long turnOver,
			String stock, List<StockDetails> stocks, double maxStock, double minStock, double avgStock) {
		super();
		this.compnyCode = compnyCode;
		this.compnyName = compnyName;
		this.compnyCeo = compnyCeo;
		this.website = website;
		this.turnOver = turnOver;
		this.stock = stock;
		this.stocks = stocks;
		this.maxStock = maxStock;
		this.minStock = minStock;
		this.avgStock = avgStock;
	}
	public CompnyStocks() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int compnyCode;
	private String compnyName;
	private String compnyCeo;
	private String website;
	private long turnOver;
	private String stock;
	List<StockDetails> stocks;
	private double maxStock;
	private double minStock;
	private double avgStock;
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
	public List<StockDetails> getStocks() {
		return stocks;
	}
	public void setStocks(List<StockDetails> stocks) {
		this.stocks = stocks;
	}
	public double getMaxStock() {
		return maxStock;
	}
	public void setMaxStock(double maxStock) {
		this.maxStock = maxStock;
	}
	public double getMinStock() {
		return minStock;
	}
	public void setMinStock(double minStock) {
		this.minStock = minStock;
	}
	public double getAvgStock() {
		return avgStock;
	}
	public void setAvgStock(double avgStock) {
		this.avgStock = avgStock;
	}
	@Override
	public String toString() {
		return "CompnyStocks [compnyCode=" + compnyCode + ", compnyName=" + compnyName + ", compnyCeo=" + compnyCeo
				+ ", website=" + website + ", turnOver=" + turnOver + ", stock=" + stock + ", stocks=" + stocks
				+ ", maxStock=" + maxStock + ", minStock=" + minStock + ", avgStock=" + avgStock + "]";
	}
	

}
