package com.company;

// leetcode 166.
//    Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
//        If the fractional part is repeating, enclose the repeating part in parentheses.
//        For example,
//        Given numerator = 1, denominator = 2, return "0.5".
//        Given numerator = 2, denominator = 1, return "2".
//        Given numerator = 2, denominator = 3, return "0.(6)".

import java.util.HashMap;

public class Main {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append((numerator > 0)^(denominator > 0) ? "-" : "");
        long num = Math.abs((long)numerator); // avoid overflow!
        long den = Math.abs((long)denominator);
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) { // recurring part found!
                int offset = map.get(num);
                res.insert(offset, "(");
                res.append(")");
                return res.toString();
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {

        System.out.println(fractionToDecimal(-1, 2));
        System.out.println(fractionToDecimal(-2, -1));
        System.out.println(fractionToDecimal(-4, 3));

    }

}