package com.study.iterator;

import java.util.ArrayList;

public class Main {
    static void main() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("tom", 11));
        list.add(new User("jerry", 22));

        for (User user : list) {
            if (user.getAge() == 11) {
                list.add(new User("zhangsan", 3));
            }
        }

        for (User user : list) {
            System.out.println(user);
        }
    }
}
