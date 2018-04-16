package com.company;

// LC 647. Substring Anagrams

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> findAnagrams(String s, String p) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return res;
        }

        // char[] chs = new char[26];
        int[] chs = new int[26];
//         for (Character ch : p.toCharArray()) {
//      also works
        for (char ch : p.toCharArray()) {
            chs[ch - 'a']++;
        }
        int start = 0, end = 0;
        int count = p.length();
        while (end < s.length()) {
            if (end - start == p.length() && chs[s.charAt(start++) - 'a']++ >= 0) {
                count++;
            }
            if (chs[s.charAt(end++) - 'a']-- >= 1) {
                count--;
            }
            if (count == 0) {
                res.add(start);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(('c' - 'a'));

    }
}