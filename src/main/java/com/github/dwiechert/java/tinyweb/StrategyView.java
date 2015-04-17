package com.github.dwiechert.java.tinyweb;

import java.util.List;
import java.util.Map;

public class StrategyView implements View {
	private final RenderingStrategy viewRenderer;

	public StrategyView(final RenderingStrategy viewRenderer) {
		this.viewRenderer = viewRenderer;
	}

	@Override
	public String render(final Map<String, List<String>> model) {
		try {
			return viewRenderer.renderView(model);
		} catch (final Exception e) {
			throw new RenderingException(e);
		}
	}
}
