package com.github.dwiechert.java.tinyweb;

public class HttpResponse {
	private final String body;
	private final Integer responseCode;

	public String getBody() {
		return body;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	private HttpResponse(final Builder builder) {
		this.body = builder.body;
		this.responseCode = builder.responseCode;
	}

	public static class Builder {
		private String body;
		private Integer responseCode;

		public Builder body(final String body) {
			this.body = body;
			return this;
		}

		public Builder responseCode(final Integer responseCode) {
			this.responseCode = responseCode;
			return this;
		}

		public HttpResponse build() {
			return new HttpResponse(this);
		}

		public static Builder newBuilder() {
			return new Builder();
		}
	}
}
