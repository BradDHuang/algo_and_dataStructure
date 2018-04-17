//Binary search is a famous question in algorithm.
//
//For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
//
//If the target number does not exist in the array, return -1.
//
//Example
//If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.


package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
                // or start = mid + 1
            } else {
                end = mid;
                // or end = mid - 1
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
        // write your code here
        int[] s = {1,1,1,2};
        int t = 2;

        System.out.print(binarySearch(s, t));
    }

}