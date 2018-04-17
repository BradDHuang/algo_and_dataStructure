package com.company;

// LeetCode 43. Multiply Strings
// Note:
//        The length of both num1 and num2 is < 110.
//        Both num1 and num2 contains only digits 0-9.
//        Both num1 and num2 does not contain any leading zero.

//        You must not use any built-in BigInteger library or convert the inputs to integer directly.

public class Main {

    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "0";
        }

        int[] digits = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int product = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                int p1 = i + j, p2 = i + j + 1;

                int sum = product + digits[p2]; // 这里digits[p2]被累加；
                digits[p1] += sum / 10;         // 这里digits[p1]被累加。

                digits[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int d : digits) {
            if (!(d == 0 && sb.length() == 0)) { // eg. [0, 1, 0, 2]
                sb.append(d);
            }
        }

        if (sb.length() == 0) return "0";
        return sb.toString();
    }

    public static void main(String[] args) {

        String n1 = "24", n2 = "15";
        System.out.println(multiply(n1, n2));

//        int[] digits = new int[3];
//        for (int digit : digits) {
//            System.out.println(digit); // 0
//        }

//        StringBuilder sb = new StringBuilder();
//        System.out.println(sb.length()); // 0

    }
}