package com.study.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProxyExampleTest {

    @Test
    void controlsAccessToRealSubject() {
        int[] realPlayCount = {0};
        ProxyExample.Video realVideo = () -> {
            realPlayCount[0]++;
            return "playing";
        };
        ProxyExample.VideoProxy proxy = new ProxyExample.VideoProxy(realVideo);

        assertEquals("playing", proxy.play());
        assertEquals("playing", proxy.play());
        assertEquals(2, proxy.playCount());
        assertEquals(1, realPlayCount[0]);
    }
}
