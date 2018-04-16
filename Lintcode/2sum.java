package com.company;

// LC 56. Two Sum

import java.util.HashMap;

// HashMap vs 两根指针
// Two Pointers: 先排序，然后左右夹逼，排序O(n log n)，左右夹逼 O(n) ，最终O(n log n)。
// 但是注意，这题需要返回的是下标，而不是数字本身，因此这个方法不妥。

public class Main {

    public static int[] twoSum(int[] numbers, int target) {
        // Write your code here

        if (numbers == null || numbers.length < 2) {
            return null;
        }
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                res[0] = map.get(target - numbers[i]);
                res[1] = i;
                return res;
            }
            map.put(numbers[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        // write your code here

        int[] nums = {2, 1, 3, 9};
        int t = 10;
        int[] res = twoSum(nums, t);
//        System.out.print(twoSum(nums, 3));
        System.out.print("nums[" + res[0] + "] + nums[" + res[1] + "] = " + t);
    }

}