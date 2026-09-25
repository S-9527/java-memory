package com.study.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemplateMethodExampleTest {

    @Test
    void runsTemplateStepsInFixedOrder() {
        TemplateMethodExample.DataProcessor processor =
                new TemplateMethodExample.ReportProcessor();

        assertEquals("saved:REPORT", processor.process());
    }
}
