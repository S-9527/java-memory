package com.study.patterns;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MediatorExampleTest {

    @Test
    void routesMessagesThroughMediator() {
        MediatorExample.ChatRoom room = new MediatorExample.ChatRoom();
        MediatorExample.Participant alice = new MediatorExample.Participant("alice");
        MediatorExample.Participant bob = new MediatorExample.Participant("bob");
        room.register(alice);
        room.register(bob);

        room.send("alice", "hello");

        assertEquals(List.of(), alice.inbox());
        assertEquals(List.of("alice:hello"), bob.inbox());
    }
}
