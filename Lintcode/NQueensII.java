package com.company;

// LC 34. N-Queens II

public class Main {
    static int res = 0;
    public static int totalNQueens(int n) {

        boolean[] cols = new boolean[n];
        boolean[] slash1 = new boolean[n*2];
        boolean[] slash2 = new boolean[n*2];
        helper(0, cols, slash1, slash2, n);
        return res;
    }
    private static void helper(int row, boolean[] cols, boolean[] slash1, boolean[] slash2, int n) {
        if (row == n) {
            res++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int s1 = col - row + n; // \
            int s2 = col + row;     // /
            if (cols[col] || slash1[s1] || slash2[s2]) {
                continue;
            }
            cols[col] = true; slash1[s1] = true; slash2[s2] = true;
            helper(row + 1, cols, slash1, slash2, n);
            cols[col] = false; slash1[s1] = false; slash2[s2] = false;
        }
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println(totalNQueens(4));
    }
}