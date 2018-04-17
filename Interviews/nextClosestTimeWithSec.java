package com.company;

public class Main {

    public static String nextClosestTime(String time) {
        int h = Integer.valueOf(time.substring(0, 2));
        int m = Integer.valueOf(time.substring(3, 5));
        int s = Integer.valueOf(time.substring(6, 8));
        while (true) {
            s++;
            if (s == 60) {

//                直接避免2步合作1步使用s++ 或者 ++s！

//            if (s++ == 60) { // 00:10:60
                s = 0;
                m++;
                if (m == 60) {
                    m = 0;
                    h++;
                    h %= 24;
                }
            }
            String cur = String.format("%02d:%02d:%02d", h, m, s);

            boolean valid = true;
            for (int i = 0; i < cur.length(); i++) {
                if (time.indexOf(cur.charAt(i)) < 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                return cur;
            }
        }
    }
    public static void main(String[] args) {
//        String[] times = new String[]{"23:59:59", "00:00:00", "00:10:56", "19:34:56"};
//        for (int i = 0; i < times.length; i++) {
//            String res = nextClosestTime(times[i]);
//            System.out.println(res);
//        }

        int i = 59;
        if (i++ == 60) i = 0;
        System.out.println(i);

        if (++i == 61) i = 0;
        System.out.println(i);
//      ++i increments the number before the current expression is evaluted,
//      whereas i++ increments the number after the expression is evaluated.
    }
}