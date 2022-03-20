package org.example.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者问题
 */
public class Main {
    static int count = 3;
    static int max = 3;
    private final ReentrantLock lock = new ReentrantLock();
    Condition cp = lock.newCondition();
    Condition cc = lock.newCondition();


    class Producer implements Runnable {
        @Override
        public void run() {
            lock.lock();
            // 这个地方必须使用while，不能用if。想一想why ^_^
            while (count >= max) {
                System.out.println(Thread.currentThread().getName() + " The Container is full.");
                try {
                    cp.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
            System.out.println(Thread.currentThread().getName() + " put an object. Now the count is " + count);
            cc.signalAll();
            lock.unlock();
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            lock.lock();
            while (count <= 0) {
                System.out.println(Thread.currentThread().getName() + " The Container is empty.");
                try {
                    cc.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            System.out.println(Thread.currentThread().getName() + " get an object. Now the count is " + count);
            cp.signalAll();
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        new Thread(main.new Producer(), "producerA").start();
        new Thread(main.new Producer(), "producerB").start();
        new Thread(main.new Consumer(), "ConsumerA").start();
        new Thread(main.new Consumer(), "ConsumerB").start();
    }
}
