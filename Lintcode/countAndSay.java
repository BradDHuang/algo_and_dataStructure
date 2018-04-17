package com.company;
// lc 420
public class Main {

    public static String countAndSay(int n) {
        // write your code in Java SE 8

        if (n <= 0) return "";

        String str = "1";
        while(--n > 0) {

            StringBuilder sb = new StringBuilder();

//            int count = 1;
            for (int i = 0; i < str.length(); i++) {

                int count = 1;
                while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                    i++;
                }
                sb.append(count);
                sb.append(str.charAt(i));
            }
            str = sb.toString();
        }

        return str;
    }

    public static void main(String[] args) {

//        int count = 0;
//        int num = 1;
//        StringBuilder sb = new StringBuilder();
//        sb.append(count);
//        sb.append(num);
//        System.out.println(sb);
        System.out.println(countAndSay(6));
    }
}