package com.company;

// LC 418. Integer to Roman

public class Main {

    public static String intToRoman(int n) {
        // Write your code here

        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] chars = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            while (n >= nums[i]) {
                n -= nums[i];
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // write your code here
        System.out.print(intToRoman(2345));
    }

}