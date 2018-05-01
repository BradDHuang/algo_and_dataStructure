package com.company;

// lc 817.

public class NumMatrix {

    private int[][] arr, bit; // intro. Binary Index Tree.
    int n, m;

    public NumMatrix(int[][] matrix) {
//        this.matrix = matrix;
//        if (matrix.length == 0 || matrix[0].length == 0) return;
        n = matrix.length;
        m = matrix[0].length;
        arr = new int[n][m];
        bit = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
//        if (m == 0 || n == 0) return;
        int diff = val - arr[row][col];
        arr[row][col] = val;
        for (int i = row + 1; i <= n; i = i + lowbit(i)) {
//            for (int j = col; j <= n; j = j + lowbit(j)) {
            for (int j = col + 1; j <= m; j = j + lowbit(j)) {
                bit[i][j] += diff;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        // O(n^2) => TLE!
//        int sum = 0;
//        for (int i = row1; i <= row2; i++) {
//            for (int j = col1; j <= col2; j++) {
//                sum += matrix[i][j];
//            }
//        }

        // BIT.
//        if (m == 0 || n == 0) return 0;
//        return sum(row2, col2) - sum(row2, col1) - sum(row1, col2) + sum (row1, col1);
        return (sum(row2, col2) + sum(row1 - 1, col1 - 1) - sum(row1 - 1, col2) - sum(row2, col1 - 1));
    }
    private int sum(int row, int col) {
        int sum = 0;
        for (int i = row + 1; i > 0; i = i - lowbit(i)) {
            for (int j = col + 1; j > 0; j = j - lowbit(j)) {
                sum += bit[i][j];
            }
        }
        return sum;
    }

    private int lowbit(int i) {
        return i & (-i);
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}};
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        obj.update(3, 2, 2);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
    }

}

/*
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */