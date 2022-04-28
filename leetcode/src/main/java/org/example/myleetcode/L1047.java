package org.example.myleetcode;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class L1047 {
    /**
     * 删除字符串中的所有相邻重复项
     *
     * 思路二：直接用字符串作为栈（省去从栈转化为字符串）
     */
    class Solution {
        public String removeDuplicates(String s) {
            Deque<Character> deque = new LinkedList<>();
            for (Character c : s.toCharArray()) {
                if (!deque.isEmpty() && deque.peekLast().equals(c)) {
                    deque.pollLast();
                } else {
                    deque.addLast(c);
                }
            }

            StringBuilder ret = new StringBuilder();
            Iterator<Character> iterator = deque.stream().iterator();
            while (iterator.hasNext()) {
                ret.append(iterator.next());
            }
            return ret.toString();
        }
    }
}
