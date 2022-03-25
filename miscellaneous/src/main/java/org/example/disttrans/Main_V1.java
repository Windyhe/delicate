package org.example.disttrans;

import java.util.ArrayList;

public class Main_V1 {

    private enum Result {
        RUNNING, SUCCEED, FAILED
    }

    static class Task extends Thread {
        private Result result = Result.RUNNING;
        private String name;
        private int timeSeconds;
        private boolean success;

        public Task(String name, int timeSeconds, boolean success) {
            this.name = name;
            this.timeSeconds = timeSeconds;
            this.success = success;
        }

        public Result getResult() {
            return result;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(timeSeconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " ended.");
            result = success ? Result.SUCCEED : Result.FAILED;
        }
    }

    public static void main(String[] args) {
        Task t1 = new Task("task1", 3, true);
        Task t2 = new Task("task2", 4, true);
        Task t3 = new Task("task3", 1, false);

        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);

        tasks.forEach(Thread::start);

        // Version 1: 主动监视
        for (; ; ) {
            for (Task task : tasks) {
                if (task.getResult() == Result.FAILED) {
                    System.exit(0);
                }
            }
        }
    }
}
