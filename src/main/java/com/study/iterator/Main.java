package com.study.iterator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    static void main() throws IOException {
        ArrayList<User> userList = new ArrayList<>();
        readUsers(user -> {
            System.out.println(user);
            userList.add(user);
        });
    }

    private static void readUsers(Consumer<User> userConsumer) throws IOException {
        List<String> lines = Files.readAllLines(new File("demo.user").toPath());
        for (String line : lines) {
            String midString = line.substring(1, line.length() - 1);
            String[] split = midString.split(",");
            String name = split[0];
            int age = Integer.parseInt(split[1]);
            User user = new User(name, age);
            userConsumer.accept(user);
        }
    }
}
