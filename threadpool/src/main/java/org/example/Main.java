package org.example;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池
 *
 * 构建线程的方式：
 * 1. 继承Thread 2. 实现Runnable（常用） 3. 实现Callable（可以返回值，配合Future） 4. 线程池（Executors）
 */
public class Main {
    public static void main(String[] args) {
        // 阿里规范不允许这种方式，因为其控制粒度不够细，推荐手动创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // 线程池的7个参数
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1000,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(2), new ThreadFactory() {
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("abc");
                return t;
            }
        },new ThreadPoolExecutor.AbortPolicy());
//        public ThreadPoolExecutor(int corePoolSize,
//        int maximumPoolSize,
//        long keepAliveTime,
//        TimeUnit unit,
//        BlockingQueue<Runnable> workQueue,
//        ThreadFactory threadFactory,
//        RejectedExecutionHandler handler)

        // 线程池的执行流程
        /**
         * 1. 优先使用核心线程执行任务
         * 2. 核心线程满了，放入阻塞队列
         * 3，队列满了，使用非核心线程
         * 4. 线程超过最大线程数，使用拒绝策略
         */

        threadPoolExecutor.execute();
        Object o = new Object();
        System.out.println();
    }
}
