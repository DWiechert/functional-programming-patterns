package com.github.dwiechert.tinyweb;

import java.util.List;
import java.util.Map;

public abstract class TemplateController implements Controller {
	private final View view;

	public TemplateController(final View view) {
		this.view = view;
	}

	@Override
	public HttpResponse handleRequest(final HttpRequest request) {
		Integer responseCode = 200;
		String responsebody = "";

		try {
			final Map<String, List<String>> model = doRequest(request);
			responsebody = view.render(model);
		} catch (final ControllerException e) {
			responseCode = e.getStatusCode();
		} catch (final RenderingException e) {
			responseCode = 500;
			responsebody = "Exception while rendering.";
		} catch (final Exception e) {
			responseCode = 500;
		}

		return HttpResponse.Builder.newBuilder().body(responsebody).responseCode(responseCode).build();
	}

	protected abstract Map<String, List<String>> doRequest(HttpRequest request);
}
