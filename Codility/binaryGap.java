package com.company;

// A binary gap within a positive integer N
// is any maximal sequence of consecutive zeros
// that is surrounded by ones at both ends in the binary representation of N.
//        For example, number 9 has binary representation 1001 and contains a binary gap of length 2.

public class Main {

    public static int longestBinaryGap(int n) {
        String[] str = Integer.toString(n, 2).split("");
        int zeroCount = 0, longestGap = 0;
        for (int i = 0; i < str.length - 1; i++) {
            if (str[i + 1].equals("0")) {
                zeroCount++;
            } else {
                if (str[i].equals("0")) {
                    if (zeroCount > longestGap) {
                        longestGap = zeroCount;
//                        zeroCount = 0;
                    }
                    zeroCount = 0;
                }
            }
        }
        return longestGap;
    }

    public static void main(String[] args) {

        int n = 1041;
        int res = longestBinaryGap(n);
//        for (int i = 0; i < str.length; i++) {
        System.out.println(res);
//        }
    }

}