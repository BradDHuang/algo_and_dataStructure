package com.company;
// lc 111.
public class Main {

    public static int climbStairs(int n) {

        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n - 1];
    }

    public static void main(String[] args) {

        System.out.println(climbStairs(4));
    }

}