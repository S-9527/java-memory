package com.study.patterns;

import java.util.Objects;

public final class ProxyExample {
    private ProxyExample() {
    }

    public interface Video {
        String play();
    }

    public static final class RealVideo implements Video {
        @Override
        public String play() {
            return "playing";
        }
    }

    public static final class VideoProxy implements Video {
        private final Video realVideo;
        private String cachedVideo;
        private int playCount;

        public VideoProxy(Video realVideo) {
            this.realVideo = Objects.requireNonNull(realVideo);
        }

        @Override
        public String play() {
            playCount++;
            if (cachedVideo == null) {
                cachedVideo = realVideo.play();
            }
            return cachedVideo;
        }

        public int playCount() {
            return playCount;
        }
    }
}
