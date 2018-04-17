package com.company;

public class Main {

    public static int solution(int[] A) {
        // write your code in Java SE 8

        // 80% performance!
//        if (A.length == 1) return A[0];
//        int minPre = 0;
//        int sum = 0;
//        int max = Integer.MIN_VALUE;
//        for (int a : A) {
//            sum += a;
//            max = Math.max(max, sum - minPre);
//            minPre = Math.min(minPre, sum);
//        }
//        return max;

//        Kadane's Algorithm (DP)
        if (A.length == 1) return A[0];
        int max = A[0];
        int updatedMax = A[0];
        for (int i = 1; i < A.length; i++) {
            max = Math.max(A[i], max + A[i]); // (2, 5), (-6, -1), (4, 3), (2, 6).
            updatedMax = Math.max(updatedMax, max);
        }
        return updatedMax;
    }

    public static void main(String[] args) {

        int[] A = {3,2,-6,4,2};
        System.out.println(solution(A));
    }
}