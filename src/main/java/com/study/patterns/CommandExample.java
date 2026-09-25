package com.study.patterns;

import java.util.ArrayDeque;
import java.util.Deque;

public final class CommandExample {
    private CommandExample() {
    }

    public interface Command {
        void execute();

        void undo();
    }

    public static final class CommandInvoker {
        private final Deque<Command> history = new ArrayDeque<>();

        public void run(Command command) {
            command.execute();
            history.push(command);
        }

        public void undoLast() {
            Command command = history.pop();
            command.undo();
        }
    }

    public static final class TextEditor {
        private String text = "";

        public void setText(String text) {
            this.text = text;
        }

        public String text() {
            return text;
        }
    }

    public static final class ReplaceTextCommand implements Command {
        private final TextEditor editor;
        private final String before;
        private final String after;

        public ReplaceTextCommand(TextEditor editor, String after) {
            this.editor = editor;
            this.before = editor.text();
            this.after = after;
        }

        @Override
        public void execute() {
            editor.setText(after);
        }

        @Override
        public void undo() {
            editor.setText(before);
        }
    }
}
