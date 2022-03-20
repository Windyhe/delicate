package org.example.deadlock;

/**
 * 哲学家就餐
 */
public class Main {
    public static void main(String[] args) {
        Chopstick c0 = new Chopstick(0);
        Chopstick c1=new Chopstick(1);
        Chopstick c2 = new Chopstick(2);
        Chopstick c3=new Chopstick(3);
        Chopstick c4 = new Chopstick(4);

        Philosopher philosopher0 = new Philosopher(0, c0, c4);
        Philosopher philosopher1 = new Philosopher(1, c1, c0);
        Philosopher philosopher2 = new Philosopher(2, c2, c1);
        Philosopher philosopher3 = new Philosopher(3, c3, c2);
        Philosopher philosopher4 = new Philosopher(4, c4, c3);

        philosopher0.start();
        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
    }
}
