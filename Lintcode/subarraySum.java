package com.company;

// LC 138. Subarray Sum

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static List<Integer> subarraySum(int[] nums) {

        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return res;
        }

        // <value, index>
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res.add(map.get(sum) + 1);
                res.add(i);
                return res;
            }
            map.put(sum, i);
        }
        return res;
    }

    public static void main(String[] args) {

//        int[] nums = new int[]{-4, 1, 2, -3, 5}; // [0, -4, -3, -1, -4, 1]
        int[] nums = new int[]{-3, 1, 2, -3, 4}; // [0, -3, -2, 0, -3, 1]
        System.out.println(subarraySum(nums).get(0));
        System.out.println(subarraySum(nums).get(1));
    }
}