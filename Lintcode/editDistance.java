package com.company;
// lc 119.
public class Main {

    public static int minDistance(String word1, String word2) {

        if (word1 == null || word2 == null) return 0;
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= l2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
//                if (word1.charAt(i) == word2.charAt(j)) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String s1 = "mart";
        String s2 = "karma";
        System.out.println(minDistance(s1, s2)); // 3.
    }

}