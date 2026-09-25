package com.study.patterns;

import java.util.ArrayList;
import java.util.List;

public final class CompositeExample {
    private CompositeExample() {
    }

    public interface FileNode {
        int size();
    }

    public record FileLeaf(String name, int bytes) implements FileNode {
        @Override
        public int size() {
            return bytes;
        }
    }

    public static final class Directory implements FileNode {
        private final List<FileNode> children = new ArrayList<>();

        public Directory add(FileNode child) {
            children.add(child);
            return this;
        }

        @Override
        public int size() {
            return children.stream().mapToInt(FileNode::size).sum();
        }
    }
}
