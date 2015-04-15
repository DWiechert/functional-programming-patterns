package com.github.dwiechert.tinyweb;

public interface Filter {
	HttpRequest doFilter(HttpRequest request);
}
