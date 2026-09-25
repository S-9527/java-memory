package com.study.factorymethod.exporter;

import java.util.Objects;

public final class ExportService {
    private final ExporterFactory exporterFactory;

    public ExportService(ExporterFactory exporterFactory) {
        this.exporterFactory = Objects.requireNonNull(exporterFactory, "导出器工厂不能为空");
    }

    public String export(String content) {
        return exporterFactory.createExporter().export(content);
    }
}
