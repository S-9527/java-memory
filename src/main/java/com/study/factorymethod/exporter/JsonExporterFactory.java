package com.study.factorymethod.exporter;

public final class JsonExporterFactory extends ExporterFactory {
    @Override
    public Exporter createExporter() {
        return new JsonExporter();
    }
}
