package com.company;

// LC 124. Longest Consecutive Sequence

import java.util.HashSet;

public class Main {

    public static int longestConsecutive(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
        int lcs = 0;

        for (int i = 0; i < num.length; i++) {
            int up = num[i] + 1;
            int down = num[i] - 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            // return lcs = Math.max(lcs, up - down - 1);
            lcs = Math.max(lcs, up - down - 1);
            // [1, 2, 3, 4], up = 5, down = 0.
        }
        // return Math.max(lcs, up - down - 1);
        return lcs;
    }

    public static void main(String[] args) {
        // write your code here

//        HashSet<Integer> set = new HashSet<Integer>();
//        set.add(1);
//        System.out.println(set.contains(1));
//        System.out.println(set.add(1));
//        set.add(2);
//        System.out.println(set);
        int[] arr = {100, 4, 200, 1, 3, 2, 2};
        int lcs = longestConsecutive(arr);

        System.out.println(lcs);
    }
}