package com.study.patterns;

import java.util.ArrayList;
import java.util.List;

public final class PrototypeExample {
    private PrototypeExample() {
    }

    public static class Document implements Cloneable {
        private String title;
        private List<String> tags;

        public Document(String title, List<String> tags) {
            this.title = title;
            this.tags = new ArrayList<>(tags);
        }

        public Document copy() {
            try {
                Document copy = (Document) super.clone();
                copy.tags = new ArrayList<>(tags);
                return copy;
            } catch (CloneNotSupportedException exception) {
                throw new IllegalStateException("文档必须支持复制", exception);
            }
        }

        public String title() {
            return title;
        }

        public void title(String title) {
            this.title = title;
        }

        public List<String> tags() {
            return tags;
        }
    }
}
