package com.company;

// LC 16. Permutations II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        if (nums.length == 0) {
            res.add(new ArrayList<>()); // boolean!

            return res;
        }

        // For dealing with the duplicate solutions, we should sort it first.
        Arrays.sort(nums);
        // 标记
        boolean[] visited = new boolean[nums.length];

        helper(res, new ArrayList<>(), nums, visited);
        return res;
    }
    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {

            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            // 例子：1 2 3 4 4 4 5 6 7 8
            // 444这个的选法只能:4, 44, 444连续这样选
            if (visited[i] || (i >0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
//            if (visited[i] || (i >0 && nums[i] == nums[i - 1] && visited[i - 1])) {
                continue;
            }

            list.add(nums[i]);

            visited[i] = true;
            helper(res, list, nums, visited);
            list.remove(list.size() - 1);

            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = permuteUnique(new int[]{3, 1, 1});
        System.out.println(res.size());
    }
}