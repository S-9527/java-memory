package com.study.patterns;

import java.util.HashMap;
import java.util.Map;

public final class FlyweightExample {
    private FlyweightExample() {
    }

    public record StyleKey(String font, int size) {
    }

    public record TextStyle(String font, int size) {
    }

    public static final class StyleFactory {
        private final Map<StyleKey, TextStyle> cache = new HashMap<>();

        public TextStyle get(String font, int size) {
            return cache.computeIfAbsent(
                    new StyleKey(font, size),
                    key -> new TextStyle(key.font(), key.size()));
        }

        public int cachedStyleCount() {
            return cache.size();
        }
    }

    public record Glyph(char value, TextStyle style, int position) {
        public String render() {
            return position + ":" + value + ":" + style.font() + style.size();
        }
    }
}
