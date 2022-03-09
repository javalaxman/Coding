package com.iiht.market.model;

public class Successresponse {
	private String msg;
	private int statusCode;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "Successresponse [msg=" + msg + ", statusCode=" + statusCode + "]";
	}
	public Successresponse(String msg, int statusCode) {
		super();
		this.msg = msg;
		this.statusCode = statusCode;
	}
	public Successresponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}
