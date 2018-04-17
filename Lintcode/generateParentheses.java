package com.company;
// lc 427.
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<String> generateParentheses(int n) {
        // write your code in Java SE 8
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        helper(res, "", n, n);
        return res;
    }
    private static void helper(List<String> res, String s, int left, int right) {
        if (left > right) { // "())...", invalid!
            return;
        }
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0) {
            helper(res, s + "(", left - 1, right);
        }
        if (right > 0) {
            helper(res, s + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {

//        String s1 = "hi";
//        String s2 = s1 + "hi";
//        System.out.println(s2);
        List<String> res2 = generateParentheses(2);
        List<String> res3 = generateParentheses(3);
        System.out.println(res2);
        System.out.println(res3);
    }

}