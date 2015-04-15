package com.github.dwiechert.tinyweb;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
	private final String body;
	private final String path;
	private final Map<String, String> headers;

	public String getBody() {
		return body;
	}

	public String getPath() {
		return path;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	private HttpRequest(final Builder builder) {
		this.body = builder.body;
		this.path = builder.path;
		this.headers = builder.headers;
	}

	public static class Builder {
		private String body;
		private String path;
		private Map<String, String> headers;

		public Builder body(final String body) {
			this.body = body;
			return this;
		}

		public Builder path(final String path) {
			this.path = path;
			return this;
		}

		public Builder addHeader(final String headerName, final String headerValue) {
			if (headers == null) {
				headers = new HashMap<>();
			}
			headers.put(headerName, headerValue);
			return this;
		}

		public Builder headers(final Map<String, String> headers) {
			this.headers = headers;
			return this;
		}

		public HttpRequest build() {
			return new HttpRequest(this);
		}

		public static Builder newBuilder() {
			return new Builder();
		}

		public static Builder builderFrom(final HttpRequest request) {
			final Builder builder = new Builder();
			builder.path(request.getPath());
			builder.body(request.getBody());

			for (final Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
				builder.addHeader(entry.getKey(), entry.getValue());
			}

			return builder;
		}
	}
}
