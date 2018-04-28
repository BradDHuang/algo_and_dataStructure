package com.company;

// leetcode 227. Basic Calculator II
// The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
// The integer division should truncate toward zero.
//        "3+2*2" = 7
//        " 3/2 " = 1
//        " 3+5 / 2 " = 5

import java.util.Stack;

public class Main {

    public static int calculate(String s) {
        // write your code here
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(i + 1)) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
            }
//            else if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
            // i == s.length() - 1 is for the last push.
                if (sign == '+') stack.push(num);
                if (sign == '-') stack.push(-num);
                if (sign == '*') stack.push(stack.pop() * num);
                if (sign == '/') stack.push(stack.pop() / num);

                sign = s.charAt(i); // mark sign first, calculate later!
                num = 0;
            }
        }
        for (int n : stack) {
            res += n;
        }
        return res;
    }

    public static void main(String[] args) {

        String s = " 1+2*3-5 / 2";
        System.out.println(calculate(s));
        int num = -5;
        System.out.println(-num);

    }

}