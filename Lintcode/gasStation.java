package com.company;

// LC 187. Gas Station

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