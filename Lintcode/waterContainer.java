package com.company;

// LC 383. Container With Most Water

public class Main {

    public static int maxArea(int[] heights) {
        // write your code here

        if (heights == null) {
            return 0;
        }

        int l = 0, r = heights.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, Math.min(heights[l], heights[r]) * (r - l));
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] h = new int[]{1, 3, 2};
        int res = maxArea(h);
        System.out.print(res);
    }
}