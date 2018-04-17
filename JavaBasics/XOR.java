package com.company;

//  A non-empty zero-indexed array A consisting of N integers is given.
//        The array contains an odd number of elements,
//        and each element of the array can be paired with another element that has the same value,
//        except for one element that is left unpaired.

import java.util.HashMap;

public class Main {

    public static int unpairedEle(int[] A) {
        // write your code in Java SE 8

//        HashMap 这个方法有些test cases 过不了！
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < A.length; i++) {
//            if (!map.containsKey(A[i])) {
//                map.put(A[i], 0);
//            } else {
////                map.put(A[i], map.get(A[i]++));
//                int count = map.get(A[i]);
//                map.put(A[i], count + 1);
//            }
//        }
//        for (int i = 0; i < A.length; i++) {
//            if (map.get(A[i]) == 0) {
//                return A[i];
//            }
//        }
//        return A[0];

//        O(1) space
        int result = 0;
        for (int a : A) {
            result ^= a;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] A = {9,3,9,3,9,7,9};
        int res = unpairedEle(A);

        System.out.println(res);

    }

}