package com.company;

// LC 187. Gas Station
// 这个题的做法是，
// 从任意站点出发，走一圈，找到这一圈里剩余Gas最少的那一站，
// 然后从这一站出发走一圈，如果在这一站出发可以顺利走完全程，那么就可行，
// 否则就不可行。
// 像这样的算法，是需要进行数学证明来证明其正确性的，
// 面试官是没有能力出这样的面试题的。

public class Main {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        if (gas.length != cost.length) return -1;

        int total = 0, sum = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = gas[i] - cost[i];
                start = i;
            } else {
                sum += gas[i] - cost[i];
            }
        }

        if (total < 0) {
            return -1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1, 1, 3, 1};
        int[] cos = new int[]{2, 2, 1, 1};
        int res = canCompleteCircuit(gas, cos);
        System.out.println("the start gas station is gas[" + res + "].");

    }
}