
package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

    public static ArrayList minWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new ArrayList();
        }
        ArrayList<Integer> res = new ArrayList<>();
        int len = nums.length;
//        int resIdx = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] > nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i - k + 1 >= 0) {
                res.add(nums[deque.peek()]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,12,11,-5};
        ArrayList<Integer> res = minWindow(arr, 2);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

}




