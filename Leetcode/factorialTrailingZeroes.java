package com.company;

// leetcode 172. Factorial Trailing Zeroes

public class Main {

    public static int trailingZeroes(int n) {

        // in O(logN). return n/5 + n/25 + n/125 + n/625 + n/3125+...;
        // 2 * 5 = 10, we only need to find 5n while n >= 1;
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {

        int factorial = 1;
        for (int i = 10; i > 0; i--) {
            factorial *= i;
        }
        System.out.println(factorial);
        System.out.println(trailingZeroes(10));

    }

}