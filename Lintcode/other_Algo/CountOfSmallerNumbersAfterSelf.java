package com.company;

// lc 1297.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<Integer> countSmaller(int[] nums) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        Integer[] res = new Integer[nums.length];
        int index;
        for (int i = nums.length - 1; i >= 0; i--) { // from "right" to "left".
            index = findIndex(list, nums[i]);
            res[i] = index; // from "right" to "left".
//            list.add(nums[i]);

            list.add(index, nums[i]);
        }
        return Arrays.asList(res);
    }
    private static int findIndex(List<Integer> list, Integer num) {
        if (list.size() == 0) return 0;
        int start = 0, end = list.size() - 1;
        if (num > list.get(end)) return end + 1;
        if (num <= list.get(0)) return 0;
        // binary search.
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (list.get(mid) < num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (num <= list.get(start)) return start;
        return end;
    }

    public static void main(String[] args) {

        int[] A = {4, 2, 5, 1};
        System.out.println(countSmaller(A));
    }

}