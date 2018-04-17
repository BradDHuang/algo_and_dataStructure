package com.company;
// tapeEquilibrium
//  A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.
//        Any integer P, such that 0 < P < N, splits this tape into two non-empty parts:
//        A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
//        The difference between the two parts is the value of:
//        |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

public class Main {

    public static int minDiff(int[] A) {
        // write your code in Java SE 8

        int leftSum = 0, rightSum = 0;
        int minDiff = Integer.MAX_VALUE;
//        for (int i = 0; i < A.length; i++) {
//            rightSum += A[i];
        for (int a : A) {
            rightSum += a;
        }
        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i];
            rightSum -= A[i];
            minDiff = Math.min(minDiff, Math.abs(leftSum - rightSum));
        }
        return minDiff;
    }

    public static void main(String[] args) {

        int[] A = {3,1,2,4,3};
        System.out.println(minDiff(A));

    }

}