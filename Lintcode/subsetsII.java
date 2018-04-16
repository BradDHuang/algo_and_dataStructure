package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);

        List<Integer> subset = new ArrayList<Integer>();

        helper(0, nums, subset, results);

        return results;
    }


    // 递归三要素
    // 1. 递归的定义：在 nums 中找到所有以 subset 开头的的集合，并放到 results
    private static void helper(int startIndex,
                               int[] nums,
                               List<Integer> subset,
                               List<List<Integer>> results) {
        // 2. 递归的拆解
        // deep copy
        // results.add(subset);
        //        因为在递归拆解中对subset有增删处理，
// 如果是res.add(subset)的话，那么加进去了之后对subset再进行处理也会改变res中的值，
// 因为两者是对同一个对象的引用，为了防止这种情况发生，这里用deep copy，
// 即创建一个与subset内容相同的新的对象存到res中，那样之后对subset的修改不会对res造成影响
        results.add(new ArrayList<Integer>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            // [1] -> [1,2]

            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }

            subset.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 results
            helper(i + 1, nums, subset, results);
            // [1,2] -> [1]  回溯
            subset.remove(subset.size() - 1);
        }

        // 3. 递归的出口
        // return;
    }

    public static void main(String[] args) {
        // write your code here
        int[] s = {1,1,1};

        System.out.print(subsetsWithDup(s));
    }

}