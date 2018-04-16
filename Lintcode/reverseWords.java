package com.company;

//LC 53. Reverse Words in a String

public class Main {

    public static String reverseWords(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].equals("")) {
                // 两个空格之间为“空”
                // leading space 前也为“空”
                sb.append(arr[i]).append(" ");
            }
        }

        if (sb.length() == 0) {
            return "";
        } else {
            return sb.substring(0, sb.length() - 1);
            // 去掉append 最后一个word 带上的“空格”
        }
    }

    public static void main(String[] args) {
        // write your code here

        String str = " ";
        System.out.println(str.length());
        String newStr = reverseWords(str);
        System.out.println(newStr.length());

        str = " the sky is blue";
        String[] arr = str.split(" ");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        System.out.println(arr.length);
        newStr = reverseWords(str);
        System.out.println(newStr);

        str = "the sky is blue ";
        arr = str.split(" ");
        System.out.println(arr.length);
        newStr = reverseWords(str);
        System.out.println(newStr);

        str = "the  sky is blue";
        arr = str.split(" ");
        System.out.println(arr.length);
        newStr = reverseWords(str);
        System.out.println(newStr);
    }
}