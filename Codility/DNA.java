package com.company;

import java.util.Arrays;

public class Main {

    public static int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8

        // O(M * N)
//        char[] chars = S.toCharArray();
//        int[] res = new int[P.length];
//        int ele;
//        char c;
//        for (int i = 0; i < P.length; i++) {
//            ele = 4;
//            for (int j = P[i]; j <= Q[i]; j++) {
//                c = chars[j];
//                if (c == 'A') {
//                    ele = 1;
//                    break;
//                } else if (c == 'C') {
//                    if (ele > 2) ele = 2;
//                } else if (c == 'G') {
//                    if (ele > 3) ele = 3;
//                }
//            }
//            res[i] = ele;
//        }
//        return res;

        // O(M + N)
        int[][] gen = new int[3][S.length() + 1];
//        int A = 0, C = 0, G = 0;
        int A, C, G;
        for (int i = 0; i < S.length(); i++) {

            A = 0; C = 0; G = 0;
            if (S.charAt(i) == 'A') {
                A = 1;
            }
            if (S.charAt(i) == 'C') {
                C = 1;
            }
            if (S.charAt(i) == 'G') {
                G = 1;
            }
            gen[0][i + 1] = gen[0][i] + A;
            gen[1][i + 1] = gen[1][i] + C;
            gen[2][i + 1] = gen[2][i] + G;
        }
        int start, end;
        int[] res = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            start = P[i];
            end = Q[i] + 1;
            if (gen[0][end] - gen[0][start] > 0) {
                res[i] = 1;
            } else
            if (gen[1][end] - gen[1][start] > 0) {
                res[i] = 2;
            } else
            if (gen[2][end] - gen[2][start] > 0) {
                res[i] = 3;
            } else {
                res[i] = 4;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String S = "CAGCCTA";
        int[] P = {2,5,0};
        int[] Q = {4,5,6};
        int[] res = solution(S,P,Q);
        System.out.println(Arrays.toString(res));

    }

}