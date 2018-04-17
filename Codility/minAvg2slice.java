package com.company;

public class Main {

    public static int solution(int[] A) {
        // write your code in Java SE 8

        // O(n^2)
//        int[] preSum = new int[A.length + 1];
//        for (int i = 1; i < preSum.length; i++) {
//            preSum[i] = preSum[i - 1] + A[i - 1];
//        }
//        double avg = Double.MAX_VALUE;
//        int res = 0;
//        for (int i = 1; i < A.length; i++) {
//            for (int j = i + 1; j < preSum.length; j++) {
//                double temp = (double)(preSum[j] - preSum[i - 1])/(double)(j - i + 1);
//                if (temp < avg) {
//                    avg = temp;
//                    res = i - 1;
//                }
//            }
//        }
//        return res;

        // O(n)
        // (1) There must be some slices, with length of two or three,
        //     having the minimal average value among all the slices.
        // (2) And all the longer slices with minimal average
        //     are built up with these 2-element and/or 3-element small slices.
        int res = 0;
        double minAvg = ((double)(A[0] + A[1]))/2;
        double curAvg;
        for (int i = 0; i < A.length - 2; i++) {
            curAvg = ((double)(A[i] + A[i + 1]))/2;
            if (curAvg < minAvg) {
                minAvg = curAvg;
                res = i;
            }
            curAvg = ((double)(A[i] + A[i + 1] + A[i + 2]))/3;
            if (curAvg < minAvg) {
                minAvg = curAvg;
                res = i;
            }
        }
        curAvg = ((double)(A[A.length - 2] + A[A.length - 1]))/2;
        if (curAvg < minAvg) {
//            minAvg = curAvg;
            res = A.length - 2;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] A = {4,3,3};
        System.out.println(solution(A));
        double minAvg = ((double)(3 + 2))/2;
        System.out.println(minAvg);
        minAvg = ((3 + 2))/2;
        System.out.println(minAvg);
    }

}