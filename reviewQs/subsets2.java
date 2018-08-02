

package com.company;

import java.util.*;

public class Main {

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        if (nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        Arrays.sort(nums);
        ArrayList<Integer> subset = new ArrayList<>();
        helper(nums, 0, subset, res);
        return res;
    }
    private static void helper(int[] nums, int startIdx, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> res) {
        // deep copy
        res.add(new ArrayList<Integer>(subset));
        for (int i = startIdx; i < nums.length; i++) {
            // Dup check:
//            if (i != 0 && nums[i] == nums[i - 1] && i > startIdx) {
            if (i > startIdx && nums[i] == nums[i -1]) {
                continue;

            }
            subset.add(nums[i]);
            helper(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2};
        ArrayList<ArrayList<Integer>> res = subsetsWithDup(nums);
        System.out.println(res);
        // [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
        ArrayList<ArrayList<Integer>> res2 = subsetsWithDup(null);
        System.out.println(res2); // []
        int[] nums2 = new int[0];
//        System.out.println(nums2.length);
        ArrayList<ArrayList<Integer>> res3 = subsetsWithDup(nums2);
        System.out.println(res3); // [[]]
    }

}


// find all subsets => Using DFS.



