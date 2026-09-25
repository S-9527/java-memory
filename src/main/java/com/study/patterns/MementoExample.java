package com.study.patterns;

public final class MementoExample {
    private MementoExample() {
    }

    public record EditorMemento(String text) {
    }

    public static final class TextEditor {
        private String text = "";

        public void setText(String text) {
            this.text = text;
        }

        public String text() {
            return text;
        }

        public EditorMemento save() {
            return new EditorMemento(text);
        }

        public void restore(EditorMemento memento) {
            text = memento.text();
        }
    }
}
