package com.github.dwiechert.java.tinyweb;

public interface Controller {
	HttpResponse handleRequest(HttpRequest request);
}
