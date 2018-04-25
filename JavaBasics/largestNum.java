package com.company;

// lc 184.
//Given a list of non negative integers, arrange them such that they form the largest number.
//        Notice
//        The result may be very large, so you need to return a string instead of an integer.

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static String largestNumber(int[] nums) {

        // in O(N logN).
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(res, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
//                String str1 = s1 + s2;
//                String str2 = s2 + s1;
//                return str2.compareTo(str1); // 8423201
//                return str1.compareTo(str2); // 1202348
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        if (res[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : res) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        int[] nums = {1, 20, 23, 4, 8};
        System.out.println(largestNumber(nums));
        int[] nums2 = {0, 0, 0, 0, 0};
        System.out.println(largestNumber(nums2));
        
    }

}