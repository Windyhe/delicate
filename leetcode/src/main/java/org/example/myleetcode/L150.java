package org.example.myleetcode;

import java.util.Deque;
import java.util.LinkedList;

public class L150 {
    /**
     * 计算逆波兰表达式
     */
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<>();
            for (String token : tokens) {
                if ("+".equals(token)) {
                    Integer right = stack.pop();
                    Integer left = stack.pop();
                    stack.push(left + right);
                } else if ("-".equals(token)) {
                    Integer right = stack.pop();
                    Integer left = stack.pop();
                    stack.push(left - right);
                } else if ("/".equals(token)) {
                    Integer right = stack.pop();
                    Integer left = stack.pop();
                    stack.push(left / right);
                } else if ("*".equals(token)) {
                    Integer right = stack.pop();
                    Integer left = stack.pop();
                    stack.push(left * right);
                } else {
                    stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
        }
    }
}
