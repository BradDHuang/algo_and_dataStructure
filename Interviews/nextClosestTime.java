package com.company;

// LeetCode 681. Next Closest Time

public class Main {

    public static String nextClosestTime(String time) {
        int h = Integer.valueOf(time.substring(0, 2));
        int m = Integer.valueOf(time.substring(3, 5));
        while (true) {
//            m++;
            if (m++ == 60) {
                m = 0;
                h++;
                h %= 24;
            }
            String cur = String.format("%02d:%02d", h, m);

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
        String[] times = new String[]{"23:56", "00:00", "00:10", "19:34"};
        for (int i = 0; i < times.length; i++) {
            String res = nextClosestTime(times[i]);
            System.out.println(res);
        }
    }

}