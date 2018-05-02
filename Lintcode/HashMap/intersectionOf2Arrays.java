package com.company;

// lc 547. Intersection of Two Arrays

import java.util.*;

public class Main {

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums2) {
            map.put(n, 1);
        }
        for (int n : nums1) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            }
        }
        // int[] res = new int[nums1.length];
        int i = 0;
        for (int n : map.keySet()) {
            if (map.get(n) > 1) {
                // res[i++] = n;
                i++;
            }
        }
        int[] res = new int[i];
        int j = 0;
        for (int n : map.keySet()) {
            if (map.get(n) > 1) {
                res[j++] = n;
            }
        }
        return res;

        // 或者用2个HashSet
    }

    public static void main(String[] args) {

        int[] n1 = {1,2,1,2};
        int[] n2 = {2,2};
        int[] res = intersection(n1, n2);
        System.out.println(Arrays.toString(res)); // return [2]
        System.out.println(Arrays.asList(res)); // [[I@14ae5a5], 有1个Integer数组类型的对象，整个数组作为一个元素存进去的。
//        System.out.println((res)); // [I@14ae5a5
        Integer[] r = {2}; // Class Integer
        System.out.println(Arrays.asList(r)); // return [2]

        String[] s = {"yes", "lint", "code"}; // Class String
        System.out.println(Arrays.asList(s));
        System.out.println(Arrays.toString(s));
    }

}