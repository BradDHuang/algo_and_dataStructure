package com.company;

// leetcode 697. Degree of an Array
// Given a non-empty array of non-negative integers nums,
// the degree of this array is defined as the Max. frequency of any one of its elements.
//        Your task is to find the smallest possible length of
// a (contiguous) subarray of nums, that has the same degree as nums.

import java.util.HashMap;

public class Main {

    public static int findShortestSubArray(int[] nums) {

        // we need a map to calculate len.
        HashMap<Integer, Integer[]> map = new HashMap<>(); // Integer[3]: count(freq.) and 1st/last pos. of an ele.
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new Integer[]{1, i, i});
            } else {
                Integer[] t = map.get(nums[i]);
                t[0] += 1;
                t[2] = i;
//                map.put(nums[i], t);
            }
        }
        int minLen = Integer.MAX_VALUE; // subarr. len.
        int maxFre = Integer.MIN_VALUE; // degree.
        for (Integer[] values : map.values()) {
            if (values[0] > maxFre) {
                maxFre = values[0];
//                if (values[2] - values[1] + 1 < minLen) minLen = values[2] - values[1] + 1;
                minLen = values[2] - values[1] + 1; // update directly!
            } else if (values[0] == maxFre) {
                minLen = Math.min(minLen, values[2] - values[1] + 1);
            }
        }
        return minLen;
    }

    public static void main(String[] args) {

        int[] A = {1, 2, 2, 3, 1};
        int[] B = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(A)); // 2. [2, 2].
        System.out.println(findShortestSubArray(B)); // 6.

    }

}