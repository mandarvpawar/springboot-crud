package com.mvp.springboot.exception;

public class RecordNotFoundException extends Exception {
	
	private static final long serialVersionUID = -4419952279871930784L;

	public RecordNotFoundException(String message) {
		super(message);
	}

}