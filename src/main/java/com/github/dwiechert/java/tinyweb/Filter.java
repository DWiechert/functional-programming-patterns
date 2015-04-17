package com.github.dwiechert.java.tinyweb;

public interface Filter {
	HttpRequest doFilter(HttpRequest request);
}
