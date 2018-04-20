package com.company;

// lc 150. Best Time to Buy and Sell Stock II
// You may complete as many transactions as you like

public class Main {

    public static int maxProfit(int[] prices) {

//  Greedy:
//        别花时间在这个算法上，学了也学不会（每个贪心法都是完全不同的贪心，完全没有规律），基本不考，考了认倒霉就行。--9zhang 
//        贪心算法：在对问题求解时，总是做出在当前看来最好的选择。
//        即：不从整体上最优加以考虑，只求局部最优解。
//        对于此题情境，获得可能的最大利润的手段为：买入后的次日，只要股价上涨就卖出。同时如果后一天股价下跌则前一天不买入。

        if (prices == null || prices.length <= 1) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {

//        Given array [2,1,2,5,6], return (2-1)+(5-2)+(6-5)=5.=6-1.
        int[] prices = {2,1,2,5,6};
        int[] prices2 = {2,1,2,0,1};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices2));

    }

}