package com.company;

// LC 33. N-Queens

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        helper(res, new int[n], 0);
        return res;
    }
    private static void helper(List<List<String>> res, int[] queens, int position) {
        if (queens.length == position) {
            res.add(Solution(queens));
            return;
        }
        for (int col = 0; col < queens.length; col++) {
            queens[position] = col;
            if (isValid(queens, position)) {
                helper(res, queens, position + 1);
            }
        }

    }
    private static List<String> Solution(int[] queens) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                if (j == queens[i]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        return list;
    }
    private static boolean isValid(int[] queens, int position) {
//        for (int col = 0; col < queens.length; col++) {
        for (int col = 0; col < position; col++) {
            if (queens[position] == queens[col]) {
                return false;
            } else if (Math.abs(queens[position] - queens[col]) == Math.abs(position - col)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // write your code here
//        List<List<String>> res = solveNQueens(4);
        System.out.println(solveNQueens(4));
    }
}