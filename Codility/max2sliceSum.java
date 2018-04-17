package com.company;

public class Main {

    public static int solution(int[] A) {
        // write your code in Java SE 8

        // O(n) time, O(n) space.
//        if (A.length == 3) return 0;

        // 这个先找Y 的方法是错的！按 min 找到的Y 不一定是最后结果需要的。
//        int min = Integer.MAX_VALUE;
//        int idxOfY = 1, totalVal = 0;
//        for (int i = 1; i < A.length - 1; i++) {
//            totalVal += A[i];
//            if (A[i] < min) {
//                min = A[i];
//                idxOfY = i;
//            }
//        }
//        for (int i = 1; i < idxOfY; i++) {
//        }

        // 除去 X 和 Z 之后，移动Y ，Max[(Y的左边的 MaxSub) + (Y的右边 MaxSub)]即为所求解。
        int[] left = new int[A.length];
        int[] right = new int[A.length];
//        int max = Integer.MIN_VALUE;
        for (int i = 1; i < A.length - 2; i++) {
            left[i] = Math.max(left[i - 1] + A[i], 0);
            // the empty double-slice (n,n+1,n+2) with sum 0
            // is always better than any double-slice with a negative sum.
        }
        for (int i = A.length - 2; i > 1; i--) {
            right[i] = Math.max(right[i + 1] + A[i], 0);
        }

        int max = 0;
        for (int i = 1; i < A.length - 1; i++) {
            max = Math.max(left[i - 1] + right[i + 1], max);
        }
        return max;
    }

    public static void main(String[] args) {

        int[] A = {-3,-2,-1,1,2,3};
    // left =        [-, 0, 0, 1, -, -]
    // right = [-, -, 2, 3, 2, -]
    // max =      [-, 2, 3, 2, 1, -]
        System.out.println(solution(A));

    }

}