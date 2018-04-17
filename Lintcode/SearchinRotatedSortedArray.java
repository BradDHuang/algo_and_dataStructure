package com.company;

// ******
// LC 62.
// Search in Rotated Sorted Array
// ******

public class SearchinRotatedSortedArray {

    public static int search(int[] A, int target) {
        // write your code here

        if (A == null || A.length == 0) {
            // if (A == null || A.length == 0 || target == null) {
            return -1;
        }

        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[start] < A[mid]) {
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }

        }

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
        // write your code here
        int[] s = {1,1,2,6};
        int t = 6;

        System.out.print(search(s, t));
    }

}