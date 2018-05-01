package com.company;

// leetcode 334.

public class Main {

    public static boolean increasingTriplet(int[] nums) {
        // Write your code here
        if (nums == null || nums.length < 3) return false;
        // store a min. and a secondMin, then find a num > secondMin.
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
//            if (num < min) min = num;
            if (num <= min) min = num;
            // else if (num < secondMin) secondMin = num;
            // else if (num > secondMin) return true;
            else if (num <= secondMin) secondMin = num;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4};
        int[] B = {1, 2, 1, 2};
        System.out.println(increasingTriplet(A));
        System.out.println(increasingTriplet(B));
    }

}