package com.github.dwiechert.java.tinyweb.example;

import com.github.dwiechert.java.tinyweb.Filter;
import com.github.dwiechert.java.tinyweb.HttpRequest;

public class LoggingFilter implements Filter {
	@Override
	public HttpRequest doFilter(final HttpRequest request) {
		System.out.println("In Logging Filter - request for path: " + request.getPath());
		return request;
	}
}
