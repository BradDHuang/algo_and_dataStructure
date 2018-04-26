package com.company;

// lc 534.
// This time, all houses at this place are arranged in a circle.
// That means the first house is the neighbor of the last one.

public class Main {

    public static int houseRobber2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(houseRobber(nums, 0, nums.length - 2), houseRobber(nums, 1, nums.length - 1));
    }

    private static int houseRobber(int[] A, int from, int to) {
        if (A == null || A.length == 0) return 0;
        int not = 0, robbed = 0;
//        for (int n : A) {
        for (int i = from; i <= to; i++) {
            int temp = not;
            not = Math.max(not, robbed);
//            robbed = n + temp;
            robbed = A[i] + temp;
        }
        return Math.max(not, robbed);
    }

    public static void main(String[] args) {

        int[] nums = {100, 1, 2, 100}; // 102
        System.out.println(houseRobber2(nums));

    }

}