package com.company;

//import java.util.*;

// leetc. 796. Rotate String

public class Main {

    public static boolean rotateString(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0 || A.length() != B.length()) {
            return false;
        }
        /*
        String str = A + A;
        System.out.print(str + " contains " + B + "? ");
//        return str.indexOf(B) > -1;
        return str.contains(B);
        */

        // brute force solution with labeled syntax:
        search:
            for (int i = 0; i < A.length(); i++) {
                for (int j = 0; j < B.length(); j++) {
                    if (B.charAt(j) != A.charAt((j + i) % A.length())) {
                        continue search; // for outer for-loop iteration.
                    }
//                    return true;
                }
                return true;
            }
        return false;
    }

    public static void main(String[] args) {

        String A = "abcde";
        String B = "cdeab";
        String C = "cdeba";
        System.out.println(rotateString(A, B)); // true
        System.out.println(rotateString(A, C)); // false
        System.out.println(rotateString(null, null)); // false
    }

}


//  labeled syntax

//  https://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html




