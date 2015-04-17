package com.github.dwiechert.java.tinyweb;

public class ControllerException extends RuntimeException {
	private static final long serialVersionUID = 7079499045434554336L;
	private final Integer statusCode;

	public ControllerException(final Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	public Integer getStatusCode() {
		return statusCode;
	}
}
