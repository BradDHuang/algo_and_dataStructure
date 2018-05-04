package com.company;

// leetCode 454. 4Sum II
// Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are
// such that A[i] + B[j] + C[k] + D[l] is 0.
//        To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
// All integers are in the range of -2^28 to 2^28 - 1 and the result is guaranteed to be at most 2^31 - 1.

import java.util.HashMap;

public class Main {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        // use a HashMap to find (a + b) = -(c + d).
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        int res = 0;
        for (int c : C) {
            for (int d : D) {
                res += map.getOrDefault(-(c + d), 0);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] A = {1, 2};
        int[] B = {-2, -1}; // a + b (count): -1(1), 0(2), 1(1).
        int[] C = {-1, 2};
        int[] D = {0, 2}; // -(c + d): 1, -1, -2, -4.
        System.out.println(fourSumCount(A,B,C,D));
//        The 2 tuples are:
//        1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//        2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

    }

}