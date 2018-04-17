package com.company;

public class Main {

    public static int solution(int[] A) {
        // write your code in Java SE 8

        // O(n) time, O(1) space.
        if (A == null || A.length <= 1) return 0;
        int profit;
        int minPre = A[0];
        int maxProfit = 0;
        for (int i = 1; i < A.length; i++) {
            profit = A[i] - minPre;
            minPre = Math.min(minPre, A[i]);
            maxProfit = Math.max(maxProfit, profit);
        }
        if (maxProfit == 0) return 0;
        
        return maxProfit;
    }

    public static void main(String[] args) {

        int[] A = {3171,1011,1123,2011,1013,1367};
        System.out.println(solution(A));

    }

}