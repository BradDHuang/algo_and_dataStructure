package com.company;

import java.util.Arrays;

public class Main {

    public static int solution(int[] A) {
        // write your code in Java SE 8

        if (A.length < 3) return 0;
        Arrays.sort(A);
        int count = 0;
        // O(n^3)
//        for (int i = 0; i < A.length; i++) {
//            for (int j = i + 1; j < A.length; j++) {
//                int sum = A[i] + A[j];
//                for (int k = j + 1; k < A.length; k++) {
//                    if (A[k] < sum) count++;
//                }
//            }
//        }
//        return count;

        // O(n^2): for loop 每次只循环 mid.
        for (int start = 0; start < A.length - 2; start++) {
            int end = start + 2;
            for (int mid = start + 1; mid < A.length - 1; mid++) {
//            for (int mid = start + 1; mid < end; mid++) {
                while (end < A.length && A[start] + A[mid] > A[end]) {
                    System.out.println(A[start] + " + " + A[mid] + " > " + A[end]);
                    end++;
                    count += end - mid - 1;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {

        int[] A = {10,2,5,1,8,12};
        System.out.println("res: " + solution(A));
    }

}