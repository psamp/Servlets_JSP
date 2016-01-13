package com.psamp.app;

import java.io.Serializable;

public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3302489234385151803L;
	private String message;

	public Message() {

	}
	
	public Message(String mssg) {
		this.message = mssg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
