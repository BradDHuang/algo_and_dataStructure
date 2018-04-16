package com.company;

// LC 388. Permutation Sequence

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String getPermutation(int n, int k) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        int[] factor = new int[n];
        factor[0] = 1;
        for (int i = 1; i < n; i++) {
            factor[i] = i * factor[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        k -= 1;
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factor[i];
            sb.append(list.get(index));
            k %= factor[i];
            list.remove(index);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 18)); // 3421
    }

}