package com.study.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MementoExampleTest {

    @Test
    void restoresPreviousEditorState() {
        MementoExample.TextEditor editor = new MementoExample.TextEditor();
        editor.setText("draft");
        MementoExample.EditorMemento memento = editor.save();
        editor.setText("published");

        editor.restore(memento);

        assertEquals("draft", editor.text());
    }
}
