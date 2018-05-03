package com.company;

// lc 401.

import java.util.PriorityQueue;

class Pair {
    int r, c;
    int val;
    public Pair(int row, int col, int value) {
        this.r = row;
        this.c = col;
        this.val = value;
    }
}
public class Main {

    public static int kthSmallest(int[][] matrix, int k) {
        if (k == 1) return matrix[0][0];
        int m = matrix.length, n = matrix[0].length;
        if (k == m * n) return matrix[m - 1][n - 1];
        int count = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < m; i++) {
            minHeap.add(new Pair(i, 0, matrix[i][0]));
        }
        while (count < k - 1) {
            Pair top = minHeap.poll(); // count: 0 ~ (k - 2), that is, (k - 1) times poll().
            if (top.c + 1 < n) {
//                minHeap.add(new Pair(top.c + 1, top.r, matrix[top.c + 1][top.r]));
                minHeap.add(new Pair(top.r, top.c + 1, matrix[top.r][top.c + 1]));
            }
            count++;
        }
        return minHeap.poll().val; // Kth poll().
    }

//    e.g. k = 4, poll 1 add 5; poll 3 add 7; poll 4 add 8; poll 5 is the result.
    public static void main(String[] args) {

        int[][] m = {{1,5,7},
                     {3,7,8},
                     {4,8,9}};
        for (int k = 1; k <= 9; k++) {
            System.out.println(kthSmallest(m, k));
        }
    }

}