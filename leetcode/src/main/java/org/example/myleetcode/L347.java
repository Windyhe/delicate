package org.example.myleetcode;

import java.util.*;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public class L347 {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int x : nums) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        return hashMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).limit(k).mapToInt(Map.Entry::getKey).toArray();
    }

}
