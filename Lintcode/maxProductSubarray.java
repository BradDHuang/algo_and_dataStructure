package com.company;

// LC 191. Maximum Product Subarray

public class Main {

    public static int maxProduct(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = nums[0];
        g[0] = nums[0];
        // int n = nums.length;
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(nums[i], Math.max(f[i - 1] * nums[i], g[i - 1] * nums[i]));
            g[i] = Math.min(nums[i], Math.min(f[i - 1] * nums[i], g[i - 1] * nums[i]));
        }
        // int res = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (res < f[i]) {
                res = f[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        System.out.println(maxProduct(nums));
    }
}