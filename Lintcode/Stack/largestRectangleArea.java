package com.company;
// lc 122. Largest Rectangle in Histogram [hard]
import java.util.Stack;

public class Main {

    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;

        // 单调Stack in O(N).
        Stack<Integer> s = new Stack<>(); // store index.
        int res = 0;
        for (int i = 0; i <= height.length; i++) {
            int h = (i == height.length) ? 0 : height[i]; // add 0 to the end.
            while (!s.isEmpty() && h < height[s.peek()]) {
                int H = height[s.pop()];
                int W = s.isEmpty() ? -1 : s.peek();
                int area = H * (i - 1 - W);
                res = Math.max(res, area);
            }
            s.push(i);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println();

    }

}