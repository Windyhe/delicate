package org.example.disorder;

import java.io.IOException;

/**
 * this逸出问题
 */
public class ThisEscape {
    private int num = 8;

    // 不要在构造函数里启动线程
    public ThisEscape() {
        // this.num 可能为0,因为有可能读到一个半初始化的对象
        new Thread(() -> System.out.println(this.num)).start();
    }

    public static void main(String[] args) throws IOException {
        ThisEscape thisEscape = new ThisEscape();
        System.in.read();
    }
}
