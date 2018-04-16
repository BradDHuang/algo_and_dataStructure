package com.company;

// lc 41. Maximum Subarray

public class maxSubArray {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0, presum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            max = Math.max(max, sum - presum);
            presum = Math.min(sum, presum);

        }
        return max;
    }

    public static void main(String[] args) {
        // write your code here

        int[] arr = new int[]{-2,2,-3,4,-1,2,1,-5,3};
        int max = maxSubArray(arr);
        System.out.print(max);
    }

}