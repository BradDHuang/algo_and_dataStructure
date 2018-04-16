package com.company;

// LC 620. Maximum Subarray IV

public class Main {

//  一段和sum[i] - sum[j], 因为长度要>= k，
//  所以i - j >= k, 故 j <= i - k

//        sum[i] 一定的情况下，sum[j] 越小，sum[i] - sum[j]越大，
//        再看j的范围，其最小值是 sum[0] ~ sum[i - k]中的最小值。
//        综上，维护一个0 ~ i- k的最小值minSum即可。
    public static int maxSubarray4(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return 0;
        }
        int minSum = 0;
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            if (i >= k) {
                minSum = Math.min(minSum, preSum[i - k]);
                max = Math.max(max, preSum[i] - minSum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // write your code here

        int[] nums = new int[]{-1, -2, 3, -5, 7};
        System.out.print(maxSubarray4(nums, 4));
    }
    
}