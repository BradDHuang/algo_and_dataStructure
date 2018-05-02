package com.company;

// leetcode 344.

public class Main {

    public static String reverseString(String s) {
        // Write your code here
        if (s == null) return null;
        if (s.length() <= 1) return s;
//        StringBuilder sb = new StringBuilder();
//        for (int i = s.length() - 1; i >= 0; i--) {
//            sb.append(s.charAt(i));
//        }
//        return sb.toString();

        // 2 pointers.
        int l = 0, r = s.length() - 1;
        char[] str = s.toCharArray();
        while (l < r) {
            char t = str[l];
            str[l++] = str[r];
            str[r--] = t;

        }
        return new String(str);
    }

    public static void main(String[] args) {

        String s = "hello";
        System.out.println(reverseString(s));
        
    }

}