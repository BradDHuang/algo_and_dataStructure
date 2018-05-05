package com.company;

// lc 382.

import java.util.Arrays;

public class Main {

    public static int triangleCount(int[] S) {

        if (S == null || S.length < 3) return 0;
        Arrays.sort(S);
        int count = 0;
        // O(n^3)
//        for (int i = 0; i < S.length; i++) {
//            for (int j = i + 1; j < S.length; j++) {
//                int sum = S[i] + S[j];
//                for (int k = j + 1; k < S.length; k++) {
//                    if (S[k] < sum) count++;
//                }
//            }
//        }
//        return count;

        // O(n^2): for loop 每次只循环 mid.
        for (int start = 0; start < S.length - 2; start++) {
            int end = start + 2;
            // for (int mid = start + 1; mid < S.length - 1; mid++) {
//            for (int mid = start + 1; mid < end; mid++) {
            for (int mid = start + 1; mid <= end; mid++) {
                while (end < S.length && S[start] + S[mid] > S[end]) {
//                    System.out.println(S[start] + " + " + S[mid] + " > " + S[end]);
                    count += end - mid;
                    end++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] S = {4,4,4,4};
        System.out.println(triangleCount(S));
        int[] S1 = {1,2,5,8,10,12};
        System.out.println(triangleCount(S1));
        int[] S2 = {1,5,10,50};
        System.out.println(triangleCount(S2));
        int[] S3 = {2,2,3,4}; // 2,3,4 (using the first 2); 2,3,4 (using the second 2); 2,2,3.
        System.out.println(triangleCount(S3));
        System.out.println(triangleCount(null));

    }

}