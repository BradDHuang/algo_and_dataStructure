package com.company;

// lc 162.
//        The numbers in adjacent positions are different.
//        A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
//        It's guaranteed the array has at least one peak.
//        The array may contain multiple peeks, find any of them.
//        The array has at least 3 numbers in it.

public class Main {

    public static int findPeak(int[] A) {
        int start = 1, end = A.length - 2;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (A[mid] < A[mid + 1]) start = mid;
            else if (A[mid] < A[mid - 1]) end = mid;
            else return mid; // save time!
        }
        if (A[start] > A[end]) return start;
        return end;
    }

    public static void main(String[] args) {
        
        int[] A = {1, 2, 1, 3, 4, 5, 7, 6};
        System.out.println(findPeak(A));
    }

}