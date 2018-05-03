package com.company;

// lc 58. 4Sum
// Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
//        The solution set must not contain duplicate quadruplets.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<List<Integer>> fourSum(int[] numbers, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if (numbers == null || numbers.length < 4) return res;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 3; i++) { // 1st num.
            if (i > 0 && numbers[i] == numbers[i - 1]) continue; // No dup. solution.
            for (int j = i + 1; j < numbers.length - 2; j++) { // 2nd num.
                if (j > i + 1 && numbers[j] == numbers[j - 1]) continue; // No dup. solution.
                int l = j + 1, h = numbers.length - 1; // l is the 3rd(lower) index, h is the 4th(higher) index.
                while (l < h) {
                    int sum = numbers[i] + numbers[j] + numbers[l] + numbers[h];
                    if (sum == target) {
                        res.add(Arrays.asList(numbers[i], numbers[j], numbers[l], numbers[h]));
                        while (l < h && numbers[l] == numbers[l + 1]) l++; // No dup. solution.
                        while (l < h && numbers[h] == numbers[h - 1]) h--; // No dup. solution.
                        l++;
                        h--;
                    } else if (sum < target) l++;
                    else h--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

//        List<Integer> list = Arrays.asList(1,2,3,4);
//        System.out.println(list);

        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> res = fourSum(nums, 0);
        System.out.println(res);

    }

}