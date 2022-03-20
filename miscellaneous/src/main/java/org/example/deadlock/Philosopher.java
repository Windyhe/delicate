package org.example.deadlock;

public class Philosopher extends Thread {
    private final int id;
    private final Chopstick left;
    private final Chopstick right;

    public Philosopher(int id, Chopstick left, Chopstick right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        if (id % 2 == 0) {
            synchronized (left) {
                try {
                    // 拿起左边的筷子
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (right) {
                    try {
                        // 拿起右边的筷子开始吃饭
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            synchronized (right) {
                try {
                    // 拿起右边的筷子
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (left) {
                    try {
                        // 拿起左边的筷子开始吃饭
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        System.out.println("Philosopher" + id + "has eaten up.");
    }
}
