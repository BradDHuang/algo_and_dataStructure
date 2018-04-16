package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        ArrayList<Integer> subset = new ArrayList<>();
        helper(nums, 0, subset, res);
        return res;
    }
    private static void helper(int[] nums, int startIndex, ArrayList<Integer> subset, List<List<Integer>> res){
//        res.add(subset);
//        因为在递归拆解中对subset有增删处理，
// 如果是res.add(subset)的话，那么加进去了之后对subset再进行处理也会改变res中的值，
// 因为两者是对同一个对象的引用，为了防止这种情况发生，这里用deep copy，
// 即创建一个与subset内容相同的新的对象存到res中，那样之后对subset的修改不会对res造成影响
        res.add(new ArrayList<>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
//            res.add(subset);
            helper(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }

    }

    public static void main(String[] args) {
        // write your code here

        int[] nums = new int[]{4, 2};
        System.out.println(subsets(nums));
    }
}