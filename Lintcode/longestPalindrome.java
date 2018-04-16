package com.company;

// LC 200. Longest Palindromic Substring

public class Main {

    public static String longestPalindrome(String s) {
        // write your code here

        // DP: O(n^2)
        if (s == null || s.length() == 0) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);

                if (dp[i][j]) {

                    // max = Math.max(max, j - i + 1);
                    if (j - i + 1 > max) {

                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "hitherehowru";
        String pa = longestPalindrome(str);
        System.out.print(pa);
    }
}