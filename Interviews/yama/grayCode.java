package com.company;

//import java.util.*;

// gray code:
// a binary numeral system where 2 successive values differ in only one bit.

public class Main {

    public static boolean isGrayCode(byte term1, byte term2) {

        int diffBitsCnt = 0;
        byte x = (byte)(term1 ^ term2); // XOR, int !
        while (x != 0) {
            x = (byte)(x & (x - 1));
            diffBitsCnt++;
        }
        System.out.print("diffBitsCnt: " + diffBitsCnt + " == 1 ? ");
        return diffBitsCnt == 1;

    }

    public static void main(String[] args) {

        byte term1 = 8;
        byte term2 = 9;
        byte term3 = 7;
        byte x = (byte)(term1 ^ term2); // XOR, int !
        System.out.println(x); // 9
        System.out.println(isGrayCode(term1, term2)); // (1000, 1001) true
        System.out.println(isGrayCode(term1, term3)); // (1000, 0111) false
    }

}







