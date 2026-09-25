package com.study.patterns;

public final class TemplateMethodExample {
    private TemplateMethodExample() {
    }

    public abstract static class DataProcessor {
        protected abstract String read();

        protected abstract String transform(String data);

        protected String save(String data) {
            return "saved:" + data;
        }

        public final String process() {
            String data = transform(read());
            return save(data);
        }
    }

    public static final class ReportProcessor extends DataProcessor {
        @Override
        protected String read() {
            return "report";
        }

        @Override
        protected String transform(String data) {
            return data.toUpperCase();
        }
    }
}
