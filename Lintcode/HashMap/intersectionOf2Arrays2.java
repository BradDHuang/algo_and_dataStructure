package com.company;

// lc 548. Intersection of Two Arrays II

import java.util.*;

public class Main {

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
//         HashMap<Integer, Integer> map = new HashMap<>();
//         HashMap<Integer, Integer> resMap = new HashMap<>();
//         for (int n : nums2) {
// //            map.put(n, map.getOrDefault(n, 1) + 1);
//             map.put(n, map.getOrDefault(n, 0) + 1);
//         }
//         for (int n : nums1) {
// //            if (map.containsKey(n)) {
//             if (map.containsKey(n) && map.get(n) > 0) {
//                 map.put(n, map.get(n) - 1);
// //                resMap.put(n, map.get(n));
//                 resMap.put(n, resMap.getOrDefault(n, 0) + 1);
//             }
//         }
//         int i = 0;
//         for (int n : resMap.keySet()) {
//             i += resMap.get(n);
//         }
//         int[] res = new int[i];
//         int j = 0;
//         for (int n : resMap.keySet()) {
//             while (resMap.get(n) > 0) {
//                 res[j++] = n;
//                 resMap.put(n, resMap.get(n) - 1);
//             }
//         }
//         return res;
        
        // use 1 HashMap + List.
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int n : nums1) {
            if (map.containsKey(n)) {
                if (map.get(n) > 0){
                    map.put(n, map.get(n) - 1);
                    list.add(n);
                }
            }
        }
        int[] res = new int[list.size()];
        int j = 0;
//        for (int n : list) {
        for (Integer n : list) {
                res[j++] = n;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] n1 = {1,2,1};
        int[] n2 = {2,2,1};
        int[] res = intersection(n1, n2);
        System.out.println(Arrays.toString(res)); // return [1, 2]

    }

}