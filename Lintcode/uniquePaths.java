package com.company;
// lc 62.
public class Main {

    public static int uniquePaths(int m, int n) {
//        int res = 0;
//        if (m == 0 || n == 0) return 1;
//        int[][] f = new int[m][n];
////        f[0][0] = 1;
//        for (int i = 0; i < m; i++) {
//            f[i][0] = 1;
//        }
//        for (int j = 0; j < n; j++) {
//            f[0][j] = 1;
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                f[i][j] = f[i - 1][j] + f[i][j - 1];
//            }
//        }
//        return f[m - 1][n - 1];

        // O(N) space.
//        int[] res = new int[n];
//        res[0] = 1;
//        for (int i = 0; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                res[j] = res[j] + res[j - 1];
//            }
//        }
//        return res[n - 1];

        // O(1) space. O(m) time.
//        利用排列组合
        int count = (m - 1) + (n - 1); // 总步数
        int k = m - 1; // 向下总步数
        double res = 1; // 结果就是从count 中取k 的组合数。
        for (int i = 1; i < m; i++) {
//            System.out.println(count - k + i);
//            System.out.println(i);
//            res *= (count - k + i) / i; // 7/3 再 * 15 == 30，错误！
            res = res * (count - k + i) / i; // 数学公式。15 * 7 再 /3 == 35.
//            System.out.println(res);
        }
        return (int)res;
    }

    public static void main(String[] args) {

        System.out.println(uniquePaths(3, 3));
        System.out.println(uniquePaths(4, 5));

    }

}