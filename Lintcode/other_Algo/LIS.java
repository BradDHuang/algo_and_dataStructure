package com.company;

// lc 76.
// The longest increasing subsequence problem is to find a subsequence of a given sequence
// in which the subsequence's elements are in sorted order, lowest to highest,
// and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.

public class Main {

    public static int longestIncreasingSubsequence(int[] nums) {
        // Write your code here

//        Time complexity O(n^2) or O(n logn)
        // DP with O(n^2).
//        int[] f = new int[nums.length];
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            f[i] = 1;
//            // 定义f[i]为以第i(index)个元素为终点的最长递增子序列
//            // 如果j < i且nums[j] < nums[i]，则f[j]一定在f[i]之前
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//
//                    if (f[i] < f[j] + 1) {
//                        f[i] = f[j] + 1;
//                    }
//                    // f[i] = Math.max(f[i], f[j] + 1);
//                }
//            }
//            if (f[i] > max) {
//                max = f[i];
//            }
//        }
//        return max;

        // O(n logn) with Binary Search.
        int[] resArr = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            // Binary Search: update or append.
            // e.g. [10, 2, 5] -> [10] -update> [2] -append> [2, 5].
            while (i != j) {
                int mid = (j - i) / 2 + i;
                if (resArr[mid] < num) i = mid + 1;
                else j = mid;
            }
            resArr[i] = num;
            if (i == res) res++;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] A = {4, 2, 4, 5, 3, 7};
        System.out.println(longestIncreasingSubsequence(A));
    }

}