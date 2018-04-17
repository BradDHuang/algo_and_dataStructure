package com.company;

public class AbsDistinct {

    public static int solution(int[] A) {
        // write your code in Java SE 8

        if (A.length == 1) return 1;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) A[i] = -A[i];
            // corner case! when A[i] == Integer.MIN_VALUE;
        }
        int start = 0, end = A.length - 1;

        if (Integer.MIN_VALUE == A[start]) count++;
        while (start < A.length && Integer.MIN_VALUE == A[start]) {
            start++;
        }

        while (start <= end) {
            while (start + 1 < A.length && A[start] == A[start + 1]) {
                start++;
            }
            while (end - 1 >= 0 && A[end] == A[end - 1]) {
                end--;
            }
            if (A[start] < A[end]) {
                end--;
                count++;
//                System.out.println("< " + count);
            } else if (A[start] == A[end]) {
                end--;
                start++;
                count++;
//                System.out.println("==" + count);
            } else {
                start++;
                count++;
//                System.out.println("> " + count);
            }

        }
        return count;
    }

    public static void main(String[] args) {

        int a = Integer.MIN_VALUE;
//        int b = Integer.MAX_VALUE;
        int c = -a;
        System.out.println(c);
//        if (b + 1 == a) {
//            System.out.println("true Overflow!");
//        }
        int[] A = {a, a, a};
        System.out.println("res: " + solution(A));
    }

}