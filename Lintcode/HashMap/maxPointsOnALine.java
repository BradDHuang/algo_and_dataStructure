package com.company;

// lc 186.

import java.util.HashMap;

class Point {
    int x, y;
    Point() {x = 0; y = 0;}
    Point(int a, int b) {x = a; y = b;}
}

public class Main {

    public static int maxPoints(Point[] points) {

        // 只考虑了过原点的情况！
//        if (points == null || points.length == 0) return 0;
//        // use HashMap to count in y/x.
//        HashMap<Double, Integer> map = new HashMap<>();
//        int countZero = 0;
//        int countXZero = 0;
////        int res = 1;
//        int res = 0;
//        for (Point p : points) {
//            if (p.x == 0 && p.y == 0) {countZero++;}
//            else if (p.x == 0) {countXZero++;}
////            else if (p.y == 0) {}
//            else {
//                double yDivX = p.y / p.x;
//                if (map.containsKey(yDivX)) {
//                    int count = map.get(yDivX) + 1;
//                    if (count > res) res = count;
//                    map.put(yDivX, count);
//                } else {
//                    if (1 > res) res = 1;
//                    map.put(yDivX, 1);
//                }
//            }
//        }
//        return res > countXZero ? res + countZero : countXZero + countZero;

        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;
//        HashMap<String, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int samePoint = 0;
//            int sameX = 0;
            int sameX = 1;
            for (int j = 0; j < points.length; j++) {
                if (j != i) { // other points.
                    if (points[j].x == points[i].x && points[j].y == points[i].y) samePoint++;
                    if (points[j].x == points[i].x) {
                        sameX++;
                        continue;
                    }
                    int numerator = points[j].y - points[i].y;
                    int denominator = points[j].x - points[i].x;

                    int gcd = gcd(numerator, denominator);

                    String str = numerator/gcd + "/" + denominator/gcd;

                    map.put(str, map.getOrDefault(str, 1) + 1);

                    res = Math.max(res, map.get(str) + samePoint);
                }
            }
            res = Math.max(res, sameX);
        }
        return res;
    }
    private static int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {

        Point[] points = {new Point(2, 0), new Point(2, 1), new Point(0, 1), new Point(2, 2)};
        System.out.println(maxPoints(points));

//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(1,2);
//        System.out.println(map.getOrDefault(1, 0)); // 2
//        System.out.println(map.getOrDefault(2, 0)); // 0

    }

}