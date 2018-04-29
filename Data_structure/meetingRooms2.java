package com.company;

// lc 919.

// public class Interval {
//     int start, end;
//     Interval(int start, int end) {
//         this.start = start;
//         this.end = end;
//     }
// }

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if (intervals == null || intervals.size() == 0) return 0;
        if (intervals.size() == 1) return 1;
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsIdx = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[endsIdx]) rooms++;
            else endsIdx++;
        }
        return rooms;
    }

    public static void main(String[] args) {

        List<Interval> res = new ArrayList<>();
        Interval a = new Interval(1, 3);
        Interval b = new Interval(2, 5);
        Interval c = new Interval(4, 7);
        Interval d = new Interval(6, 8);
        res.add(a);
        res.add(b);
        res.add(c);
        res.add(d);
        System.out.println(minMeetingRooms(res));
    }

}