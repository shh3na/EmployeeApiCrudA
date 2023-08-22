package com.velocity.exception;

public class DataNotFoundfException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
     private String code;
     private String status;
     
     public DataNotFoundfException(String code,String msg,String status) {
    	super(msg);
    	 this.code=code;
    	 this.status=status;
     }

	public String getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}

}
