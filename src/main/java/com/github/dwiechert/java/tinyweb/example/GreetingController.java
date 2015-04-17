package com.github.dwiechert.java.tinyweb.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.github.dwiechert.java.tinyweb.HttpRequest;
import com.github.dwiechert.java.tinyweb.TemplateController;
import com.github.dwiechert.java.tinyweb.View;

public class GreetingController extends TemplateController {
	private static final String[] GREETING_PREFIXES = { "Hello", "Greetings", "Salutations", "Hola" };
	private final Random random;
	
	public GreetingController(final View view) {
		super(view);
		this.random = new Random();
	}

	@Override
	protected Map<String, List<String>> doRequest(final HttpRequest request) {
		final Map<String, List<String>> helloModel = new HashMap<>();
		helloModel.put("greetings", generateGreetings(request.getBody()));
		return helloModel;
	}
	
	private List<String> generateGreetings(final String namesCommaSeparated) {
		final String[] names = namesCommaSeparated.split(",");
		final List<String> greetings = new ArrayList<>();
		for (final String name : names) {
			greetings.add(makeGreeting(name));
		}
		return greetings;
	}

	private String makeGreeting(final String name) {
		final String greetingPrefix = GREETING_PREFIXES[random.nextInt(4)];
		return String.format("%s, %s", greetingPrefix, name);
	}
}
