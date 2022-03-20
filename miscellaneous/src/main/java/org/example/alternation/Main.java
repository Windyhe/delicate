package org.example.alternation;

import java.util.concurrent.locks.LockSupport;

public class Main {
    static Thread t, t1;

    public static void main(String[] args) {
        char[] chars = "abcdefgh".toCharArray();
        char[] chars1 = "12345678".toCharArray();

        t = new Thread(() -> {
            for (char c : chars) {
                System.out.println(c);
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        });


        // LockSupport比较特殊，先unpark，再park，挂起不了
        t1 = new Thread(() -> {
            for (char c : chars1) {
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(t);

            }
        });

        t.start();
        t1.start();
    }
}
