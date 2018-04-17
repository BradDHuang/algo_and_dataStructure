package com.company;

import java.util.HashMap;

public class minWindowSubstr {

    public static String minWindow(String source , String target) {
        // write your code here

        // sliding window.
        if (source == null || target == null || target.length() > source.length()) {
            return "";
        }
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < target.length(); i++) {
//            if (!map.containsKey(target.charAt(i))) {
//                map.put(target.charAt(i), 1);
//            } else {
//                map.put(target.charAt(i), map.get(target.charAt(i)) + 1);
//            }
//        }
//        for (int i = 0; i < source.length(); i++) {
//            // 如何保证target 中所有字符都被包含
//        }

        // 用int[] 代替HashMap.
        int[] count = new int[128]; // ASCII
        for (char c : target.toCharArray()) {
            count[c]++;
        }
        int totalLength = target.length();
        int min = Integer.MAX_VALUE;
        int fromIdex = 0;
        for (int i = 0, j = 0; i < source.length(); i++) {
            if (count[source.charAt(i)]-- > 0) {
                totalLength--;
//                count[source.charAt(i)]--;
            }
            while (totalLength == 0) {
                if (i - j + 1 < min) {
                    min = i -j + 1;
                    fromIdex = j;
                }
                if (++count[source.charAt(j++)] > 0) totalLength++;
            }
        }
        if (min == Integer.MAX_VALUE) return "";
        return source.substring(fromIdex, fromIdex + min);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}