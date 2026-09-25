package com.study.patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class MediatorExample {
    private MediatorExample() {
    }

    public interface ChatMediator {
        void send(String from, String message);
    }

    public static final class Participant {
        private final String name;
        private final List<String> inbox;

        public Participant(String name) {
            this(name, new ArrayList<>());
        }

        public Participant(String name, List<String> inbox) {
            this.name = Objects.requireNonNull(name);
            this.inbox = Objects.requireNonNull(inbox);
        }

        public String name() {
            return name;
        }

        public List<String> inbox() {
            return inbox;
        }

        public void receive(String message) {
            inbox.add(message);
        }
    }

    public static final class ChatRoom implements ChatMediator {
        private final List<Participant> participants = new ArrayList<>();

        public void register(Participant participant) {
            participants.add(participant);
        }

        @Override
        public void send(String from, String message) {
            for (Participant participant : List.copyOf(participants)) {
                if (!participant.name().equals(from)) {
                    participant.receive(from + ":" + message);
                }
            }
        }
    }
}
