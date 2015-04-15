package com.github.dwiechert.tinyweb;

public interface Controller {
	HttpResponse handleRequest(HttpRequest request);
}
