package com.demo.admin.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Coupon implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String couponName;
	private int couponValue;
	
	public Coupon() {
	}
	public Coupon(int id, String couponName, int couponValue) {
		super();
		this.id = id;
		this.couponName = couponName;
		this.couponValue = couponValue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public int getCouponValue() {
		return couponValue;
	}
	public void setCouponValue(int couponValue) {
		this.couponValue = couponValue;
	}
	@Override
	public String toString() {
		return "Coupon [id=" + id + ", couponName=" + couponName + ", couponValue=" + couponValue + "]";
	}
	
	
}
