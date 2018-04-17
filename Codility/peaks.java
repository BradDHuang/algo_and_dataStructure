package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int solution(int[] A) {
        // write your code in Java SE 8

        // O(n log(log n))
        int len = A.length;
        if (len < 3) return 0;
        List<Integer> peaks = new ArrayList<>();
        int count = 0;
        for (int i = 1; i < len - 1; i++) {
            if (A[i] > Math.max(A[i - 1], A[i + 1])) {
                peaks.add(i);
                count++;
            }
        }
        int blocksLen;
        for (int i = count; i > 0; i--) {

            // check if divisible first!
            if (len % i != 0) continue;

            blocksLen = len / i;

            int ithBlock = 0;
            for (int peak : peaks) {
                if (peak / blocksLen == ithBlock) {
                    ithBlock++;
                }
            }
            if (ithBlock == i) return i;
        }
        return 0;
    }

    public static void main(String[] args) {

        int[] A = {1,2,3,4, 3,4,1,2, 3,4,6,2};
        // index: [0,1,2,3][4,5,6,7][8,9,10,11]
        System.out.println(solution(A));
    }
    
}