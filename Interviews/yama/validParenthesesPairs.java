package com.company;

//import java.util.*;
import java.util.Stack;

public class Main {

    // the str only contains '(' and ')'.
    public static int checkParentheses(String str) {

        if (str == null || str.length() % 2 == 1) {
            return -1;
        }
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                s.push(')');
            } else {
                if (s.isEmpty()) {
                    return -1;
                }
                s.pop();
            }
        }
        if (!s.isEmpty()) {
            return -1;
        }
        return str.length() / 2;
    }
    public static void main(String[] args) {
        String str = "((())()())";
        System.out.println(checkParentheses(str)); // 5
    }

}






