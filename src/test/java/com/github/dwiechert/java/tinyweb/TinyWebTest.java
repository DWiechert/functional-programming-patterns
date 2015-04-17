package com.github.dwiechert.java.tinyweb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.github.dwiechert.java.tinyweb.example.GreetingController;
import com.github.dwiechert.java.tinyweb.example.GreetingRenderingStrategy;
import com.github.dwiechert.java.tinyweb.example.LoggingFilter;

public class TinyWebTest {
	@Test
	public void test() {
		final Map<String, Controller> controllers = new HashMap<>();
		controllers.put("/greeting", new GreetingController(new StrategyView(new GreetingRenderingStrategy())));
		final List<Filter> filters = new ArrayList<>();
		filters.add(new LoggingFilter());
		final TinyWeb tinyWeb = new TinyWeb(controllers, filters);

		final HttpRequest request = HttpRequest.Builder.newBuilder().path("/greeting").body("Mike,Joe,John,Steve").build();
		final HttpResponse response = tinyWeb.handleRequest(request);

		System.out.println("responseCode: " + response.getResponseCode());
		System.out.println("responseBody:\n" + response.getBody());

		assertEquals(Integer.valueOf(200), response.getResponseCode());
		assertTrue(response.getBody().startsWith("<h1>Friendly Greetings:</h1>"));
		assertEquals(5, response.getBody().split("\n").length);
	}
}
