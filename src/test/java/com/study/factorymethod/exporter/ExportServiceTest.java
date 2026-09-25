package com.study.factorymethod.exporter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExportServiceTest {

    @Test
    void csvFactoryCreatesCsvExporter() {
        Exporter exporter = new CsvExporterFactory().createExporter();

        assertEquals("csv:hello", exporter.export("hello"));
    }

    @Test
    void jsonFactoryCreatesJsonExporter() {
        Exporter exporter = new JsonExporterFactory().createExporter();

        assertEquals("json:hello", exporter.export("hello"));
    }

    @Test
    void serviceUsesTheProvidedFactory() {
        ExportService service = new ExportService(new JsonExporterFactory());

        assertEquals("json:report", service.export("report"));
    }

    @Test
    void rejectsNullFactory() {
        assertThrows(NullPointerException.class,
                () -> new ExportService(null));
    }
}
