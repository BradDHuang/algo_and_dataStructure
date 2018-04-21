package com.company;

// LC 124. Longest Consecutive Sequence

import java.util.HashSet;

public class Main {

    public static int longestConsecutive(int[] num) {

        if (num == null || num.length == 0) return 0;
        // require O(n), use HashSet!
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int i : num) set.add(i);
        for (int i : num) {
            int up = i + 1;
            int down = i - 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            res = Math.max(res, up - 1 - down);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {100, 4, 200, 1, 3, 2, 2};
        int lcs = longestConsecutive(arr);
        System.out.println(lcs);

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        System.out.println(set.contains(1));
        System.out.println(set.add(1));
        set.add(2);
        System.out.println(set);
    }

}