package com.iiht.market.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMPNY_DETAILS")
public class Compny {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int compnyCode;
	private String compnyName;
	private String compnyCeo;
	private String website;
	private long turnOver;
	private String stock;
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
	@Override
	public String toString() {
		return "Compny [compnyCode=" + compnyCode + ", compnyName=" + compnyName + ", compnyCeo=" + compnyCeo
				+ ", website=" + website + ", turnOver=" + turnOver + ", stock=" + stock + "]";
	}
	public Compny() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compny(int compnyCode, String compnyName, String compnyCeo, String website, long turnOver,
			String stock) {
		super();
		this.compnyCode = compnyCode;
		this.compnyName = compnyName;
		this.compnyCeo = compnyCeo;
		this.website = website;
		this.turnOver = turnOver;
		this.stock = stock;
	}

}
