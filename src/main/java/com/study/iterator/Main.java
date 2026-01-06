package com.study.iterator;

import java.io.File;

public class Main {
    static void main() {
        UserFile file = new UserFile(new File("demo.user"));
        for (User user : file) {
            System.out.println(user);
        }
    }
}
