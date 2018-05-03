package com.company;

// leetcode 395.
// Find the length of the longest substring T of a given string (consists of lowercase letters only)
// such that every character in T appears no less than k times.

public class Main {

    public static int longestSubstring(String s, int k) {

        // still, Sliding Window.
        // also, we need to check 26 times and find the valid & longest substr.
        int res = 0;
//        for (int i = 0; i < 26; i++) { // i is the max. distinct letters allowed.
        for (int i = 1; i <= 26; i++) { // i is the max. distinct letters allowed.
            res = Math.max(res, check(s, k, i));
        }
        return res;
    }
    private static int check(String s, int k, int i) {
        int[] count = new int[128]; // ASCII range for letters.
        int l = 0, r = 0; // 2 pointers for calculating substr length.
        int res = 0;
        int differ = 0, atLeastK = 0; // differ: different letters allowed;
        // atLeastK: mark how many different letters in the substr are at least K times.
//        while (l < s.length()) {
        while (r < s.length()) {
            if (count[s.charAt(r)]++ == 0) differ++; // new letter.
            if (count[s.charAt(r++)] == k) atLeastK++;
            while (differ > i) {
                if (count[s.charAt(l)]-- == k) atLeastK--;
                if (count[s.charAt(l++)] == 0) differ--;
            }
            if (i == differ && i == atLeastK) {
                res = Math.max(res, r - l);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String s = "ababccce";
        String s1 = "aaaceebbb";
        System.out.println(longestSubstring(s, 2)); // "ababccc", 7
        System.out.println(longestSubstring(s1, 2)); // "eebbb", 5
    }

}