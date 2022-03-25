package org.example.myleetcode;

import java.util.Stack;

public class L232 {
    public static void main(String[] args) {

    }
}

/**
 * 栈实现队列
 * 假定所有操作都是合法的
 */
class MyQueue {
    // 只进不出
    private Stack<Integer> s1;
    // 只出不进
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        dumpStack122();
        return s2.pop();
    }

    public int peek() {
        dumpStack122();
        return s2.peek();
    }

    private void dumpStack122() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
