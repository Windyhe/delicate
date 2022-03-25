package org.example.singleton;

/**
 * 单例模式的DCL实现（懒汉模式）
 */
public class DCL {
    private int num;

    // volatile 禁止指令重排序，避免获取一个半初始化状态的对象
    // volatile 保证可见性和有序性，但不保证原子性
    private volatile static DCL instance;

    private DCL() {
    }

    public static DCL getInstance() {
        if (null == instance) {  // check
            // synchronized 保证可见性和原子性，但不能保证有序性
            synchronized (DCL.class) {  // lock
                if (null == instance) {  // check
                    instance = new DCL();
                }
            }
        }
        return instance;
    }
}
