package com.company;

// lc 920.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        if (intervals == null) return true;
        if (intervals.size() <= 1) return true;
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        // for (Interval interval : intervals) {
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i - 1).end > intervals.get(i).start) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        List<Interval> res = new ArrayList<>();
        System.out.println(res);
        Interval a = new Interval(4, 5);
        Interval b = new Interval(3, 6);
        res.add(a);
        res.add(b);
        System.out.println(canAttendMeetings(res));
    }

}