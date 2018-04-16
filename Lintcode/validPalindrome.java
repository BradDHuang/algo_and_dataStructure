package com.company;

// LC 415. Valid Palindrome

public class Main {

    public static boolean isPalindrome(String s) {
        // Write your code here

        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            while (start <= s.length() - 1 && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            if (start == s.length()) { // s = ",..."
                return true;
            }
            while (end >= 0 && !Character.isLetterOrDigit(s.charAt(end))) { // s = "a."
                end--;
            }

//            while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
//            }
        }
        return true;
    }

    public static void main(String[] args) {
        // write your code here
        String s = "a is: at home? 22emoh ta sia";
        System.out.print(isPalindrome(s));
    }

}