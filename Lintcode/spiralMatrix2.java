package com.company;

import java.util.Arrays;

public class Main {

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n <= 0) {
            return new int[0][0];
        }
        int rowSt = 0, rowEnd = n - 1;
        int colSt = 0, colEnd = n - 1;

        int count = 0;

        while (rowSt <= rowEnd && colSt <= colEnd) {
//            int count = 0;
            for (int i = colSt; i <= colEnd; i++) {
                res[rowSt][i] = ++count;
            }
            rowSt++;
            for (int j = rowSt; j <= rowEnd; j++) {
                res[j][colEnd] = ++count;
            }
            colEnd--;

            if (rowSt <= rowEnd) {
                for (int k = colEnd; k >= colSt; k--) {
                    res[rowEnd][k] = ++count;
                }
                rowEnd--;
            }
            if (colEnd >= colSt) {
                for (int l = rowEnd; l >= rowSt; l--) {
                    res[l][colSt] = ++count;
                }
                colSt++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

//        {{1,2,3},
//         {8,9,4},
//         {7,6,5}};
        int[][] res = generateMatrix(3);
        System.out.println(Arrays.deepToString(res));
    }

}