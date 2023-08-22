package com.velocity.exception;

public enum ErrorCode {

	DATA_NOT_FOUND("111","data not available","data not found"),Invalid_ID("222","Invalid user input","Invalid input");
	
	private final String code;
	private final String message;
	private final String status;
	
	  ErrorCode(String code,String message,String status) {
		this.code=code;
		this.message=message;
		this.status=status;
	}


	public String getStatus() {
		return status;
	}


	public String getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}
	
	
	
	
}
