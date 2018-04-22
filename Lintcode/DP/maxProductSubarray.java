package com.company;

// LC 191. Maximum Product Subarray

public class Main {

    public static int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        // use 2 arr. to store max, min.
        int[] f = new int[nums.length];
        int[] g = new int[nums.length];
        // init.
        f[0] = nums[0];
        g[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {

            // e.g. f[i - 1] = 0,

            // g[i - 1] = -3, nums[i] = 2. => we need to store nums[i] as max.
            f[i] = Math.max(f[i - 1] * nums[i], g[i - 1] * nums[i]);
            f[i] = Math.max(f[i], nums[i]);
            g[i] = Math.min(f[i - 1] * nums[i], g[i - 1] * nums[i]);
            g[i] = Math.min(g[i], nums[i]);
        }
        int max = Integer.MIN_VALUE;
//        for (int num : nums) {
//            if (num > max) max = num;
//        }
        for (int n : f) {
            if (n > max) max = n;
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = {0, -3, 2, -4}; // 24
        System.out.println(maxProduct(nums));
    }

}