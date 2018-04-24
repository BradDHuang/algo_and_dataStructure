package com.company;

// leetcode 168. Excel Sheet Column Title

//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//        For example:
//        1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB

public class Main {

    public static String convertToTitle(int n) {

        StringBuilder sb = new StringBuilder();
        while (n > 0) {

            n--; // 1 ~ 26 -> 0 ~ 25, + 'A' -> 'A' ~ 'Z'

            sb.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(convertToTitle(26 * 27 + 1));
//        System.out.println(Character.toChars(65));
//        System.out.println((char)(65));

    }

}