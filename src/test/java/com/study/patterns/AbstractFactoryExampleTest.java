package com.study.patterns;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbstractFactoryExampleTest {

    @Test
    void createsMatchingProductFamilies() {
        AbstractFactoryExample.UiApplication darkUi =
                new AbstractFactoryExample.UiApplication(
                        new AbstractFactoryExample.DarkUiFactory());
        AbstractFactoryExample.UiApplication lightUi =
                new AbstractFactoryExample.UiApplication(
                        new AbstractFactoryExample.LightUiFactory());

        assertEquals(List.of("dark-button", "dark-checkbox"), darkUi.render());
        assertEquals(List.of("light-button", "light-checkbox"), lightUi.render());
    }
}
