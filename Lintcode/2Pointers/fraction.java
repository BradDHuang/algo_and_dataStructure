package com.company;

// leetCode 592.

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String fractionAddition(String expression) {

        // we use a List to store items. e.g. "1/3 - 1/2", we store "1/3", "-1/2".
        List<String> nums = new ArrayList<>();
        int i = 0, j = 0; // we use 2 pointers to get substring(item).
        while (j <= expression.length()) {
            if (j == expression.length() || j != i && (expression.charAt(j) == '+' || expression.charAt(j) == '-')) {
                if (expression.charAt(i) == '+') {
                    nums.add(expression.substring(i + 1, j)); // skip '+'.
                }
                else {
                    nums.add(expression.substring(i, j));
                }

                i = j; // i should be updated!
            }
            j++;
        }
        String res = "0/1";
        for (String num : nums) {
            res = add(res, num);
        }
        return res;
    }
    private static String add(String s1, String s2) {
        String[] sa1 = s1.split("/"); // not '/' !
        String[] sa2 = s2.split("/");
        int n1 = Integer.valueOf(sa1[0]);
        int d1 = Integer.valueOf(sa1[1]);
        int n2 = Integer.valueOf(sa2[0]);
        int d2 = Integer.valueOf(sa2[1]);
        int n = n1 * d2 + n2 * d1;
        int d = d1 * d2;
        if (n == 0) return "0/1"; // corner case.
        boolean isNegative = n * d < 0;

        // do not forget to get the abs. val!
        n = Math.abs(n);
        d = Math.abs(d);
        // irreducible
        int gcd = gcd(n, d);
        return (isNegative ? "-" : "") + (n / gcd) + "/" + (d / gcd);
    }
    private static int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {

//        The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
        String ex = "-1/2+2/3-3/4";
        System.out.println(fractionAddition(ex));

    }

}