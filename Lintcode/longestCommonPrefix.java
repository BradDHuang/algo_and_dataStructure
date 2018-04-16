package com.company;

// LC 78. Longest Common Prefix

public class Main {

    public static String longestCommonPrefix(String[] strs) {
        // write your code here

        if (strs == null || strs.length == 0) {

            return "";

        }

        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"abcd", "abce", "abdc", "abcc"};
        String res = longestCommonPrefix(strs);
        System.out.print(res);
    }
}