package com.company;
// lc 640.
public class Main {

    public static boolean isOneEditDistance(String s, String t) {

        if (s == null || t == null) return true;
        int ls = s.length();
        int lt = t.length();
        int len = Math.min(ls, lt);
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (ls == lt) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (ls > lt) {
                    return s.substring(i + 1).equals(t.substring(i));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return Math.abs(ls - lt) == 1;
    }

    public static void main(String[] args) {
        String s1 = "aDb";
        String s2 = "adb";
        System.out.println(isOneEditDistance(s1, s2));
//        if (s1.charAt(1) != s2.charAt(1)) {
//            System.out.println("D != d");
//        }
//        boolean bothEmpty = s1.substring(3).equals(s2.substring(3));
//        System.out.println(bothEmpty);
    }

}