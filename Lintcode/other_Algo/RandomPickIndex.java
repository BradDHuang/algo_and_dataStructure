package com.company;

// leetcode 398.
// Given an array of integers with possible duplicates, randomly output the index of a given target number.
// You can assume that the given target number must exist in the array.
// Note: The array size can be very large. Solution that uses too much extra space will not pass the judge.

import java.util.Random;

public class Main {

    Random rdm;
    int[] nums;
    public Main(int[] nums) {
        rdm = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int res = -1, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;

            if (rdm.nextInt(++cnt) == 0) {
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,3,3};
        Main obj = new Main(nums);
        System.out.println(obj.pick(3)); // 等概率返回2， 3， 4.

//        Random rdm = new Random();
//        int k = 3;
//        for (int i = 1; i <= k; i++) {
//            System.out.println(rdm.nextInt(i));
//        }

        // Proof:
//        rdm.nextInt(3) == 0, 1/3; // 返回0， 1， 2的概率相等！
//        rdm.nextInt(2) == 0, 1/2, (1 - 1/3)*1/2 == 1/3;
//        rdm.nextInt(1) == 0, 1/1, (1 - 1/3 - 1/3)*1 == 1/3.
    }

}

/*
 * Your Solution object will be instantiated and called as such:
 * Main obj = new Main(nums);
 * int param_1 = obj.pick(target);
 */