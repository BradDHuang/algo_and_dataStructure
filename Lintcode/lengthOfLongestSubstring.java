package com.company;

// LC 384. Longest Substring Without Repeating Characters

import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static int lengthOfLongestSubstring(String s) {
        // write your code here

        // HashMap
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        HashMap<Character, Integer> map = new HashMap<>();
//        int res = 0;
//        for (int i = 0, j = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                j = Math.max(j, map.get(s.charAt(i)) + 1);
//            }
//            map.put(s.charAt(i), i);
//            res = Math.max(res, i - j + 1);
//        }
//        return res;

        
        // HashSet 滑动窗口
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        int i = 0, j = 0;
        while ( i < s.length() && j < s.length()) {
            if (set.contains(s.charAt(i))) {
                // set.remove(j++);
                set.remove(s.charAt(j++));
            } else {
                // set.add(i++);
                set.add(s.charAt(i++));
                res = Math.max(res, set.size());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "hitherehowru";
        int len = lengthOfLongestSubstring(str);
        System.out.print(len);
    }
}