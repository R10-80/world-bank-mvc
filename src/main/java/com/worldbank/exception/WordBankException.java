package com.worldbank.exception;

public class WordBankException extends RuntimeException{

	/**
	 *
	 */
	private static final long serialVersionUID = -5953096808556331319L;
	/**
	 *  Custom Exception Handler
	 */

	private String code;
	private String message;

	public WordBankException (String code,String message){
		this.code=code;
		this.message=message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
