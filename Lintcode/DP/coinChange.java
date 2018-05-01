package com.company;

// lc 669.

public class Main {

    public static int coinChange(int[] coins, int amount) {
        // Write your code here
        if (amount == 0) return 0;
        if (coins == null || coins.length == 0) return -1;
        int[] f = new int[amount + 1]; // DP func.
        for (int i = 1; i <= amount; i++) { // f[0] = 0 :default value.

            f[i] = -1;
            int min = Integer.MAX_VALUE; // min. coins required.
            for (int j = 0; j < coins.length; j++) {
                // this code won't pass when there are coins of value 0.
                // 把f[i] 赋值为 -1 先，可解决此问题！
                if (i >= coins[j] && f[i - coins[j]] != -1) {
                    min = Math.min(min, f[i - coins[j]] + 1);
                }
            }
            if (min != Integer.MAX_VALUE) f[i] = min;
//            if (min == Integer.MAX_VALUE) f[i] = -1;
//            else f[i] = min;
//            f[i] = min == Integer.MAX_VALUE ? -1 : min;
            
            System.out.println("f[" + i + "] = " + f[i]);
        }
        return f[amount];
        // e.g. f[11] = f[11 - 5] + 1 = (f[6 - 5] + 1) + 1 = 3.
    }

    public static void main(String[] args) {

//        int[] A = {2, 5, 1};
//        System.out.println(coinChange(A, 11)); // 3 coins at least.
        int[] B = {0, 1, 5};
        System.out.println(coinChange(B, 6));
    }

}