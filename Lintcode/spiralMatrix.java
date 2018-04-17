package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }
        int rowSt = 0, rowEnd = matrix.length - 1;
        int colSt = 0, colEnd = matrix[0].length - 1;
        while (rowSt <= rowEnd && colSt <= colEnd) {
            for (int i = colSt; i <= colEnd; i++) {
                res.add(matrix[rowSt][i]);
            }
            rowSt++;
            for (int j = rowSt; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowSt <= rowEnd) {
                for (int k = colEnd; k >= colSt; k--) {
                    res.add(matrix[rowEnd][k]);
                }
                rowEnd--;
            }
            if (colEnd >= colSt) {
                for (int l = rowEnd; l >= rowSt; l--) {
                    res.add(matrix[l][colSt]);
                }
                colSt++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[][] mat = new int[][]{  {1,2,3},
                                    {4,5,6},
                                    {7,8,9}};
        System.out.println(spiralOrder(mat));
    }

}