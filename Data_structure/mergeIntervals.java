package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {

    public static List<Interval> merge(List<Interval> intervals) {

        // Challenge
//        O(n log n) time and O(1) extra space.
        if (intervals == null || intervals.size() <= 1) return intervals;
        // [(1,4),(0,2),(3,5)]：乱序情况！
//        Collections.sort(intervals, new IntervalComparator());
        Collections.sort(intervals, (a,b) -> a.start - b.start);

        List<Interval> res = new ArrayList<>();

        Interval last = intervals.get(0); // 上一个。
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start <= last.end) {
                last.end = Math.max(last.end, interval.end);
            } else {
                res.add(last);
                last = interval;
            }
        }

        res.add(last);

        return res;
    }
//    private static class IntervalComparator implements Comparator<Interval> {
//        public int compare(Interval a, Interval b) {
//            return a.start - b.start;
//        }
//    }

    public static void main(String[] args) {

        List<Interval> list = new ArrayList<>();
        list.add(new Interval(2,3));
        list.add(new Interval(5,7));
        list.add(new Interval(1,4));
        list.add(new Interval(7,8));
//        list.add(new Interval(15,18));
        List<Interval> res = merge(list);
        for (Interval interval : res) {
            System.out.println("(" + interval.start + ", " + interval.end + ")");
        }
    }

}