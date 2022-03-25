package org.example.myleetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L225 {
}

/**
 * 用队列实现栈
 * <p>
 * Java堆栈Stack类已经过时，Java官方推荐使用Deque替代Stack使用。
 *
 * 还可以用一个队列实现：将队列中元素依次弹出再进入队列尾，即可弹出队尾元素，同时保持队列不变（*）
 */
class MyStack {

    private Queue<Integer> queue1 = new LinkedList<Integer>();
    private Queue<Integer> queue2 = new LinkedList<Integer>();

    public MyStack() {

    }

    public void push(int x) {
        reverseQueue(queue2, queue1);
        queue1.add(x);
    }

    /**
     * q1 反转到q2
     *
     * @param q1
     * @param q2
     */
    private void reverseQueue(Queue<Integer> q1, Queue<Integer> q2) {
        List<Integer> tmp = new ArrayList<Integer>();
        while (!q1.isEmpty()) {
            tmp.add(q1.poll());
        }
        for (int i = tmp.size() - 1; i >= 0; --i) {
            q2.add(tmp.get(i));
        }
    }

    public int pop() {
        reverseQueue(queue1, queue2);
        return queue2.poll();
    }

    public int top() {
        reverseQueue(queue1, queue2);
        return queue2.peek();
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */