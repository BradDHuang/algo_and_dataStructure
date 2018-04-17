package com.company;

//  A small frog wants to get to the other side of the road.
//        The frog is currently located at position X
//        and wants to get to a position greater than or equal to Y.
//        The small frog always jumps a fixed distance, D.

public class Main {

    public static int countJumps(int X, int Y, int D) {
        // write your code in Java SE 8

//        int res = 0;
//        while (X < Y) {
//            X += D;
//            res++;
//        }
//        return res;

        if (X == Y) return 0;
//        return (Y - X)/D + 1; // For example, for the input (1, 5, 2) the solution returned a wrong answer (got 3 expected 2).
        
        // 边界处理！
        return (Y - X - 1)/D + 1;
    }

    public static void main(String[] args) {

        int x = 1, y = 5, d = 2;
        System.out.println(countJumps(x, y, d));

    }

}