package com.company;
// lc 512.
public class Main {

    public static int numDecodings(String s) {
//        if (s == null || s.length() == 0) return 0;
//        if (s.length() == 1 && s.charAt(0) != '0') return 1;
        // DP in O(N) space.
//        int[] dp = new int[s.length() + 1];
//        dp[0] = 1;
//        dp[1] = s.charAt(0) != '0' ? 1 : 0;
//        for (int i = 2; i < dp.length; i++) {
//            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
//            int twoDigits = Integer.valueOf(s.substring(i - 2, i));
//            if (oneDigit > 0 && oneDigit <= 9) {
//                dp[i] += dp[i - 1];
//            }
//            if (twoDigits > 9 && twoDigits <= 26) {
//                dp[i] += dp[i - 2];
//            }
//        }
//        return dp[s.length()];

        // DP in O(1) space.
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        // d2: decode ways of s[i-2], d1: decode ways of s[i-1].
        int d1 = 1, d2 = 1;
        for (int i = 1; i < s.length(); i++) {
            // zero voids ways of the last because zero cannot be used separately.
            if (s.charAt(i) == '0') d1 = 0;
//            if ((s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') && s.charAt(i) <= '6') {
//            some cases wont pass! eg. 17.
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
            // possible two-digit letter, so new d1 is sum of both, while new d2 is the old d1.
                d1 = d1 + d2;
                d2 = d1 - d2;
            } else { // one-digit letter, no new way added.
                d2 = d1;
            }
        }
        return d1;
    }

    public static void main(String[] args) {

        String s1 = "1231";
//        String s2 = "0231"; // 0 在开头，无法decode。
        String s3 = "1201"; // 只能 1 20 1 -> A T A.
        String s4 = "312";
        String s5 = "1301";
        System.out.println(numDecodings(s1));
//        System.out.println(numDecodings(s2));
        System.out.println(numDecodings(s3));
        System.out.println(numDecodings(s4));
        System.out.println(numDecodings(s5));
//        System.out.println(Integer.valueOf("02"));

    }

}
