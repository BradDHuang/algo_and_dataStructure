package com.company;

// leetcode 347.

import java.util.*;

public class Main {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 1) + 1);
        }
        // Heap.
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue()); // Comparator, lambda func.
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};
        System.out.println(topKFrequent(nums, 2));

    }

}