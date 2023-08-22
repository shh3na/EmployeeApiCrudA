package com.velocity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExcpHandle {

	@ExceptionHandler(DataNotFoundfException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse dataFoundResponse(DataNotFoundfException e) {

		ErrorResponse errs = new ErrorResponse();
		errs.setErrorCode(e.getCode());
		errs.setErrormssg(e.getMessage());
		errs.setErrorstatus(e.getStatus());
		return errs;

	}

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handleException(Throwable t) {
		
		ErrorResponse err = new ErrorResponse();
		err.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		err.setErrormssg("You enter invalid id");
		err.setErrorstatus("Wrong id");
		return err;

	}

}
