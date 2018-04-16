package com.company;

// LC 44. Minimum Subarray

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int minSubArray(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int sum = 0, preSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            sum -= nums.get(i);
            max = Math.max(max, sum - preSum);
            preSum = Math.min(preSum, sum);
        }
        return (-1) * max;
    }

    public static void main(String[] args) {
        // write your code here

        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(-1);
        A.add(-3);
        A.add(2);
        A.add(-3);

        System.out.print(minSubArray(A));
    }
}