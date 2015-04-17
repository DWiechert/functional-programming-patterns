package com.github.dwiechert.java.tinyweb.example;

import java.util.List;
import java.util.Map;

import com.github.dwiechert.java.tinyweb.RenderingStrategy;

public class GreetingRenderingStrategy implements RenderingStrategy {
	@Override
	public String renderView(Map<String, List<String>> model) {
		final List<String> greetings = model.get("greetings");
		final StringBuffer buffer = new StringBuffer();
		buffer.append("<h1>Friendly Greetings:</h1>").append("\n");
		for (final String greeting : greetings) {
			buffer.append(String.format("<h2>%s</h2>", greeting)).append("\n");
		}
		return buffer.toString();
	}
}
