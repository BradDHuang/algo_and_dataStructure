package com.company;

// lc 386.

public class Main {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        // Write your code here
        if (k <= 0 || s == null) return 0;
        if (s.length() <= k) return s.length();
        int n = 0; // num. of distinct ele.
        int j = 0; // 2 pointers.
        int len = 0;
//        char[] chars = new char[128];
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) n++;
            if (n > k) {
                while(--count[s.charAt(j++)] > 0);
                n--;
            }
            len = Math.max(len, i - j + 1);
        }
        return len;
    }

    public static void main(String[] args) {

        String s = "cebe222";
        System.out.println(lengthOfLongestSubstringKDistinct(s, 2));
    }

}