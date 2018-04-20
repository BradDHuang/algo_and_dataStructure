package com.company;

// lc 149.

public class Main {

    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) return 0;
        int max = 0;
        int low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - low;
            low = Math.min(prices[i], low);
            max = Math.max(max, profit);
        }
        return max;
    }

    public static void main(String[] args) {

//        Given array [3,2,3,1,2], return 1.
        int[] prices = {3,2,3,1,2};
        System.out.println(maxProfit(prices));

    }

}