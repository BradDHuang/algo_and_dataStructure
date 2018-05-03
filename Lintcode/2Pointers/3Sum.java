package com.company;

// lc 57. 3Sum
// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//        The solution set must not contain duplicate triplets.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<List<Integer>> fourSum(int[] numbers) { // target is 0.

        List<List<Integer>> res = new ArrayList<>();
        if (numbers == null || numbers.length < 3) return res;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) { // 1st num.
            if (i > 0 && numbers[i] == numbers[i - 1]) continue; // No dup. solution.

            int target = 0 - numbers[i];
            int l = i + 1, h = numbers.length - 1; // l is the 2nd(lower) index, h is the 3rd(higher) index.
            while (l < h) {
//                int sum = numbers[i] + numbers[l] + numbers[h]; // 改为二元运算可能会快一点。
//                if (sum == 0) {
                if (numbers[l] + numbers[h] == target) {
                    res.add(Arrays.asList(numbers[i], numbers[l], numbers[h]));
                    // List<Integer> triplet = new ArrayList<>();
                    // triplet.add(-target);
                    // triplet.add(numbers[l]);
                    // triplet.add(numbers[h]);
                    // res.add(triplet);
                    
                    while (l < h && numbers[l] == numbers[l + 1]) l++; // No dup. solution.
                    while (l < h && numbers[h] == numbers[h - 1]) h--; // No dup. solution.
                    l++;
                    h--;
//                } else if (sum < 0) l++;
                } else if (numbers[l] + numbers[h] < target) l++;
                else h--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

//        List<Integer> list = Arrays.asList(1,2,3);
//        System.out.println(list);

        int[] nums = {-1, 0, 1, -1, -4, 2};
        List<List<Integer>> res = fourSum(nums);
        System.out.println(res);
    }

}