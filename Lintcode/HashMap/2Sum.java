package com.company;

// lc 56. 2Sum
// The function twoSum should return indices
// of the two numbers such that they add up to the target, where index1 < index2.
// Please note that your returned answers (both index1 and index2) are 0-based.
//        Notice, you may assume that each input would have exactly one solution

import java.util.HashMap;

public class Main {

    public static int[] twoSum(int[] numbers, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                int[] res = {map.get(numbers[i]), i};
                return res;
            }
            map.put(target - numbers[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {

        int[] nums = {11, -2, -7, 4};
        int[] res = twoSum(nums, 9);
        System.out.println("res[0] = " + res[0] + " res[1] = " + res[1]);
    }

}