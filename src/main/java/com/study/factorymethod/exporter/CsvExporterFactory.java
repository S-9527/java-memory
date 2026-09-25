package com.study.factorymethod.exporter;

public final class CsvExporterFactory extends ExporterFactory {
    @Override
    public Exporter createExporter() {
        return new CsvExporter();
    }
}
