package com.company;

// LC 15. Permutations

import java.util.ArrayList;
import java.util.List;

public class Main {

//    tips for this question:
// return res.add(new ArrayList<>()); // boolean!
    // res.add(new ArrayList(list));
    // 如果是res.add(list)的话，
    // 那么加进去了之后对list再进行处理也会改变res中list的值!
    public static List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        if (nums.length == 0) {
            res.add(new ArrayList<>()); // boolean!

            return res;
        }
        helper(res, new ArrayList<>(), nums);
        return res;
    }
    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {

            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(res, list, nums);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[]{3, 1, 2, 4});
        System.out.println(res.size());
    }
}