package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 2sumUniquePairsList {

    public static List<ArrayList<Integer>> twoSum6(int[] nums, int target) {
        List<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums[start]);
                list.add(nums[end]);
                res.add(list);
                start++;
                end--;
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,2,46,45,46};
        int k = 47;
        List<ArrayList<Integer>> res = twoSum6(nums, k);
        System.out.println(res);
    }
    
}