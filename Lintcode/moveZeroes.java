package com.company;

//LC 539 还有另一种同样是O(n)的解法

public class Main {

    public static void moveZeroes(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }

        int start = 0;
        for (int i = 0; i <= nums.length - 1; i++) {

            if (nums[i] != 0) {

                nums[start] = nums[i];
                start++;
            }

        }

        while (start < nums.length) {
            nums[start++] = 0;
        }
    }

    public static void main(String[] args) {
        // write your code here

        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

//        System.out.println(nums[5]);
    }
}