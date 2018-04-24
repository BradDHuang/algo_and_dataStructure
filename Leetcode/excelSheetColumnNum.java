package com.company;

// leetcode 171. Excel Sheet Column Number
//Related to question Excel Sheet Column Title

//        Given a column title as appear in an Excel sheet, return its corresponding column number.
//        For example:
//        A -> 1, B -> 2, C -> 3, ... , Z -> 26, AA -> 27, AB -> 28, ...

public class Main {

    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
//        if (s.length() == 1) return s.charAt(0) - 64; // A -> 65.
//        return 26 * (s.length() - 1) + s.charAt(s.length() - 1) - 64;
//        return 26 * (s.length() - 1) + s.charAt(s.length() - 1) - 'A' + 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res *= 26;
            res += s.charAt(i) - 'A' + 1;
        }
        return res;
    }

    public static void main(String[] args) {

        String s = "CA"; // 79
        System.out.println(titleToNumber(s));

    }

}