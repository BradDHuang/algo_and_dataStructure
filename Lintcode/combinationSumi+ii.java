package com.company;
// lc 135. lc 153.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        List<Integer> list = new ArrayList<>();
//        if (target <= 0) { // All numbers (including target) will be positive integers.
//            res.add(list);
//            return res;
//        }
        Arrays.sort(candidates);
        if (candidates[0] > target) return res;
//        System.out.println("2 > 1");
        helper(res, 0, candidates, target, list);
        return res;
    }
    private static void helper(List<List<Integer>> res, int index, int[] candidates, int target, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            helper(res, i, candidates, target - candidates[i], list); // [[2, 2, 3], [3, 4], [7]] int[] A = {4,2,3,3,7};
            // 这里是i 而不是(i + 1)，是因为the same repeated number may be chosen.

            // Combination Sum II
            helper(res, i + 1, candidates, target - candidates[i], list); // [[3, 4], [7]]
            // Each number in candidates[] may only be used once in the combination.

            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] A = {4,2,2,3,7};
        System.out.println(combinationSum(A, 1));
        System.out.println(combinationSum(A, 7));
        // [[2,2,3], [7]]
    }
    
}