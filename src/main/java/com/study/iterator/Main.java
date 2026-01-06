package com.study.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    static void main() {
        ArrayList<User> users = new ArrayList<>();
        for (User user : users) {
            System.out.println(user);
        }

        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            System.out.println(user);
        }
    }
}
