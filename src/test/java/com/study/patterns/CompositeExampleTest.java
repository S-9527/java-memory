package com.study.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompositeExampleTest {

    @Test
    void treatsFilesAndDirectoriesUniformly() {
        CompositeExample.Directory root = new CompositeExample.Directory()
                .add(new CompositeExample.FileLeaf("a.txt", 10))
                .add(new CompositeExample.Directory()
                        .add(new CompositeExample.FileLeaf("b.txt", 20))
                        .add(new CompositeExample.FileLeaf("c.txt", 30)));

        assertEquals(60, root.size());
    }
}
