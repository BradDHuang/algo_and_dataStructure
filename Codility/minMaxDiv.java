package com.company;

public class Main {

    public static int solution(int K, int M, int[] A) {
        // write your code in Java SE 8

        int lower = 0;
        int upper = 0;
        for (int a : A) {
            if (a > lower) lower = a;
            upper += a;
        }
        int res = upper;
        while (lower <= upper) {
            int mid = (lower + upper) / 2;
            if (lessBlocks(A, mid, K - 1)) {
                upper = mid - 1;
                res = mid;
            } else {
                lower = mid + 1;
            }
        }
        return res;
    }

    private static boolean lessBlocks(int[] A, int val, int k) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > val) {
                sum = A[i];
                k--;
            }
            if (k < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] A = {2,1,5,1,2,2,2};
        System.out.println("res: " + solution(4,5, A));
        System.out.println("res: " + solution(3,5, A));
    }

}