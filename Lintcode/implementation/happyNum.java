package com.company;

// lc 488.
//  19 is a happy number:
//        1^2 + 9^2 = 82
//        8^2 + 2^2 = 68
//        6^2 + 8^2 = 100
//        1^2 + 0^2 + 0^2 = 1

import java.util.HashSet;

public class Main {

    public static boolean isHappy(int n) {
        // write your code here
//        if (n <= 0) return false;
        HashSet<Integer> set = new HashSet<>(); // use for finding endlessly loop-cycle
        int sqSum, digit;
        while (set.add(n)) {

            sqSum = 0;

            while (n > 0) {
                digit = n % 10;
                sqSum += digit * digit;
                n /= 10;
            }
            if (sqSum == 1) return true;
            n = sqSum;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(isHappy(19));

    }

}