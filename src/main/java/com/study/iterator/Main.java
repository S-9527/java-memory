package com.study.iterator;

public class Main {
    static void main() {
        User user = new User("zhangsan", 3);
        for (String s : user) {
            System.out.println(s);
        }
    }
}
