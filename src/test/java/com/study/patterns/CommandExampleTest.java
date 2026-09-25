package com.study.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandExampleTest {

    @Test
    void executesAndUndoesCommand() {
        CommandExample.TextEditor editor = new CommandExample.TextEditor();
        CommandExample.CommandInvoker invoker = new CommandExample.CommandInvoker();
        CommandExample.ReplaceTextCommand command =
                new CommandExample.ReplaceTextCommand(editor, "hello");

        invoker.run(command);
        assertEquals("hello", editor.text());

        invoker.undoLast();
        assertEquals("", editor.text());
    }
}
