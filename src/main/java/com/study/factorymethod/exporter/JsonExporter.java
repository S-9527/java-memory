package com.study.factorymethod.exporter;

public final class JsonExporter implements Exporter {
    @Override
    public String export(String content) {
        return "json:" + content;
    }
}
