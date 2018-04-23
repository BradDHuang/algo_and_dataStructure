package com.company;

// lc 46.
//more than half
//You may assume that the array is non-empty and the majority number always exist in the array.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int majorityNumber(List<Integer> nums) {
        // in O(n) time, O(1) extra space.

        // delete pairs of different ele. from the list, finally, the majorityNumber will stay.
        int cur = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) cur = num;
            if (num == cur) cnt++;
            else cnt--;
        }
        return cur;
    }

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 2, 2));
        System.out.println(majorityNumber(nums));

    }

}