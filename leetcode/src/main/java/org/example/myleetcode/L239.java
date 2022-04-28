package org.example.myleetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 求滑动窗口中的最大值
 */
public class L239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int[] ret = new int[nums.length - k + 1];
        // i是窗口的右边界
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                if (nums[i - k] == queue.peekFirst()) {
                    queue.pollFirst();
                }
            }
            // 从右端入队
            while (!queue.isEmpty() && nums[i] > queue.peekLast()) {
                queue.pollLast();
            }
            queue.addLast(nums[i]);
            if (i >= k - 1) {
                ret[i - k + 1] = queue.peekFirst();
            }
        }
        return ret;
    }
}
