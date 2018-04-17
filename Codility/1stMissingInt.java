package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

public class Main {

    public static int solution(int[] A) {
        // write your code in Java SE 8

//        // this solution only passed 11% cases! &TLE &Not in O(n)
//        if (A == null || A.length == 0) return 1;
//        Arrays.sort(A); // at least O(nlogn).
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < A.length; i++) {
//            if (A[A.length - 1] <= 0) {
//                return 1;
//            } else if (!list.contains(A[i])) {
//                list.add(A[i]);
//            }
//        }
//        int start = list.get(0);
//        if (start > 1) return 1;
//        for (int j = 1; j < list.size(); j++) {
//            // if (start > 1) return 1;
//            start++;
//            if (list.get(j) != start && list.get(j) > 0) {
//                return list.get(j - 1) + 1;
//                // [-100, 100] will return -99, which is wrong!
//            }
//        }
//        return list.get(list.size() - 1) + 1;

        // using sorting! // at least O(nlogn).
//        Arrays.sort(A);
//        int num = 1;
//        for (int i = 0; i < A.length; i++) {
//            // if (A[i] > num) return 1;
//            if (A[i] > num) return num;
//            if (A[i] == num) num++;
//        }
//        return num;

//        // using HashSet! // O(n) space.
//        HashSet<Integer> hs = new HashSet<>();
//        for (int i = 0; i < A.length; i++) {
//            hs.add(A[i]);
//        }
//        int num = 1;
//        while (hs.contains(num)) {
//            num++;
//        }
//        return num;

        // Bucket sort.
        // O(n) time & O(1) space.
        if (A == null) return 1;
        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != A[A[i] - 1]) {
                int t = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = t;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) return i + 1;
        }
        return A.length + 1;
    }

    public static void main(String[] args) {

        int[] s = {3, 1, 4, -1};
        System.out.print(solution(s));
    }
}