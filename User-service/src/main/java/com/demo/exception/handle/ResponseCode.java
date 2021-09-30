package com.demo.exception.handle;

public class ResponseCode {
	private String msgCode;
	private int statusCode;
	
	
	public String getMsgCode() {
		return msgCode;
	}
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "ResponseCode [msgCode=" + msgCode + ", statusCode=" + statusCode + "]";
	}
	public ResponseCode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseCode(String msgCode, int statusCode) {
		super();
		this.msgCode = msgCode;
		this.statusCode = statusCode;
	}
	
}
