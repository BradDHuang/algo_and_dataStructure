package com.company;

// LeetCode 724. Find Pivot Index

//  Given an array of integers nums, write a method that returns the "pivot" index of this array.
//        We define the pivot index as the index where the sum of the numbers to the left of the index
//                                         is equal to the sum of the numbers to the right of the index.
//        If no such index exists, we should return -1.
//  If there are multiple pivot indexes, you should return the left-most pivot index.

public class Main {

    public static int equilibrium(int[] arr) {
//        if (arr == null || arr.length == 0) return -1;

        int prefixSum = 0, suffixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            suffixSum += arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
//            prefixSum += arr[i];
            suffixSum -= arr[i];
            if (suffixSum == prefixSum) return i;
            prefixSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 3, -4, 5, 1, -6, 2, 1};
        System.out.print(equilibrium(arr));
    }
}