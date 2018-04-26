package com.company;

// leetcode 217.
// Given an array of integers, find if the array contains any duplicates.
// Your function should return true if any value appears at least twice in the array,
// and it should return false if every element is distinct.

import java.util.HashSet;

public class Main {

    public static boolean containsDuplicate(int[] nums) {
        // write your code here
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;

        // or use Arrays.sort().
    }

    public static void main(String[] args) {

        int[] nums = {100, 1, 2, 101};
        System.out.println(containsDuplicate(nums));

    }

}