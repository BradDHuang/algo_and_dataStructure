package com.company;

// 423. Valid Parentheses

import java.util.Stack;

public class Main {

    public static boolean isValidParentheses(String s) {
        // write your code here
        // if (s == null || s.length == 0) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        // for (Character char : s) {
        for (Character cha : s.toCharArray()) {

            if (cha == '(') {
                stack.push(')');
            } else if (cha == '[') {
                stack.push(']');
            } else if (cha == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != cha) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String str = "()[]{()}";
        System.out.println(isValidParentheses(str));
    }
}