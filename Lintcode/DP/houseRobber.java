package com.company;

// lc 392.

public class Main {

    public static long houseRobber(int[] A) {

//        O(n) time and O(1) memory.
        if (A == null || A.length == 0) return 0;
        long not = 0, robbed = 0;
        for (int n : A) {
            long temp = not;
            not = Math.max(not, robbed);
            robbed = n + temp;
        }
        return Math.max(not, robbed);
    }

    public static void main(String[] args) {

        int[] A = {100, 1, 1, 100};
        System.out.println(houseRobber(A));

    }

}
