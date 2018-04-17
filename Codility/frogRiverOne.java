package com.company;

// A small frog wants to get to the other side of a river.
// The frog is initially located on one bank of the river (position 0)
// and wants to get to the opposite bank (position X+1).
// Leaves fall from a tree onto the surface of the river.
//        You are given a zero-indexed array A consisting of N integers representing the falling leaves.
// A[K] represents the position where one leaf falls at time K, measured in seconds.
//        The goal is to find the earliest time when the frog can jump to the other side of the river.

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static int canJump(int X, int[] A) {
        // write your code in Java SE 8

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            if (set.size() == X) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {1,3,1,4,2,3,5,4};
        System.out.println(canJump(5, A));
    }

}