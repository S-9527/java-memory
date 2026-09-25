package com.study.patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class BuilderExample {
    private BuilderExample() {
    }

    public static final class HttpRequest {
        private final String method;
        private final String url;
        private final Map<String, String> headers;
        private final String body;

        private HttpRequest(Builder builder) {
            this.method = builder.method;
            this.url = Objects.requireNonNull(builder.url, "url 不能为空");
            this.headers = Map.copyOf(builder.headers);
            this.body = builder.body;
        }

        public String method() {
            return method;
        }

        public String url() {
            return url;
        }

        public Map<String, String> headers() {
            return headers;
        }

        public String body() {
            return body;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static final class Builder {
            private String method = "GET";
            private String url;
            private final Map<String, String> headers = new HashMap<>();
            private String body;

            public Builder method(String method) {
                this.method = Objects.requireNonNull(method, "method 不能为空");
                return this;
            }

            public Builder url(String url) {
                this.url = Objects.requireNonNull(url, "url 不能为空");
                return this;
            }

            public Builder header(String name, String value) {
                headers.put(
                        Objects.requireNonNull(name, "header name 不能为空"),
                        Objects.requireNonNull(value, "header value 不能为空"));
                return this;
            }

            public Builder body(String body) {
                this.body = body;
                return this;
            }

            public HttpRequest build() {
                return new HttpRequest(this);
            }
        }
    }
}
