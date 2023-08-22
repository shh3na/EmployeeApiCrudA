package com.velocity.exception;

public class ErrorResponse {

	
	private String errorCode;
	private String errormssg;
	private String errorstatus;
	
	public String getErrorCode() {
		return errorCode;
	}
	public String getErrorstatus() {
		return errorstatus;
	}
	public void setErrorstatus(String errorstatus) {
		this.errorstatus = errorstatus;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrormssg() {
		return errormssg;
	}
	public void setErrormssg(String errormssg) {
		this.errormssg = errormssg;
	}
	
	
	
	
	
}
