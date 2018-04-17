package com.company;

public class Main {

    public static int findLargestSumPair(int[] nums) {
        int a = Math.max(nums[0], nums[1]);
        int b = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > a) {

                b = a;
                // update a & b!

                a = nums[i];
//                continue;
            } else
            if (nums[i] > b) {
                b = nums[i];
//                continue;
            }
        }
        return a + b;
    }

    public static void main(String[] args) {

        int[] nums = {1, -2, 3, 3};
        int res = findLargestSumPair(nums);
        System.out.println(res);
    }

}