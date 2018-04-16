package com.company;

// leetcode 34. Search for a Range

import java.util.Arrays;

public class searchRange {

    public static int[] searchRange(int[] A, int target) {
        // write your code here
        int[] res = new int[]{-1, -1};
        if (A == null || A.length == 0) {
            return res;
        }

        int start = 0, end = A.length -1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] == target) {
            res[0] = start;
        } else if (A[end] == target) {
            res[0] = end;
        } else {
            // 如果A[left], A[right] != target，
            // 则表明target不存在于数组中, left = right = -1
            res[0] = res[1] = -1;
            return res;
        }

        start = 0;
        end = A.length -1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        // if (A[start] == target) {
        //     res[1] = start;
        // } else if (A[end] == target) {
        //     res[1] = end;
        if (A[end] == target) { // 如果此时A[start] == A[end] == target
            // 则res[1] = end, 所以应该先判断if (A[end] == target)
            res[1] = end;
        } else if (A[start] == target) {
            res[1] = start;
        } else {
            res[0] = res[1] = -1;
            return res;
        }
        return res;
    }

    public static void main(String[] args) {
        // write your code here

        int k = 8;
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};

        int[] res = searchRange(arr, k);
        System.out.println(res[0]);
        System.out.println(res[1]);

        System.out.println(Arrays.toString(res));

    }

}