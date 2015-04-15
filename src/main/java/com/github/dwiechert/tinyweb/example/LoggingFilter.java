package com.github.dwiechert.tinyweb.example;

import com.github.dwiechert.tinyweb.Filter;
import com.github.dwiechert.tinyweb.HttpRequest;

public class LoggingFilter implements Filter {
	@Override
	public HttpRequest doFilter(final HttpRequest request) {
		System.out.println("In Logging Filter - request for path: " + request.getPath());
		return request;
	}
}
