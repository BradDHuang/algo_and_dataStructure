package com.company;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static int solution(int[] A) {
        // write your code in Java SE 8

        // 60%: 87%, 28%.
        // timeout errors!
//        for (int n = flags; n > 0; n--) {
//            int i = peaks.get(0);
//            int next;
//            int c = 1;
//            while (true) {
//                next = i + n;
//                int pos = Collections.binarySearch(peaks, next);
//                if (pos < 0) {
//                    pos = -(pos + 1);
//                    if (pos == peaks.size()) {
//                        break;
//                    }
//                }
//                i = peaks.get(pos);
//                c++;
//            }
//            if (c == n) return c;
//        }
//        return 0;

        // O(n).
        int len = A.length;
        if (len < 3) return 0;
        boolean[] peaks = new boolean[len];
        for (int i = 1; i < len - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks[i] = true;
            }
        }
        int[] next = new int[len];
        next[len - 1] = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (peaks[i]) next[i] = i;
            else next[i] = next[i + 1];
        }
        int i = 1; // flags, try from one flag, and then 2 flags, ...
        int res = 0;
        while (i * (i - 1) + 1 <= len - 2) {
//      这里的复杂度是：1 + 2 + ... + sqrt(len), 也就是(1 + sqrt(len))* sqrt(len) / 2, 趋近于len.
            int pos = 0, num = 0;
            while (pos < len && num < i) {
                pos = next[pos];
                if (pos == -1) break;
                num++;
                pos += i;
            }
            res = Math.max(res, num);
            i++;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] A = {1,5,3,4,3,4,1,2,3,4,6,2};
        System.out.println(solution(A));
    }
}