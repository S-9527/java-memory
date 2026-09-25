package com.study.factorymethod.exporter;

public final class CsvExporter implements Exporter {
    @Override
    public String export(String content) {
        return "csv:" + content;
    }
}
