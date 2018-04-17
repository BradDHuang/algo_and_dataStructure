package com.company;
// count non divisible
import java.util.Arrays;

public class Main {

    public static int[] solution(int[] A) {
        // write your code in Java SE 8

        // O(n^2)
//        if (A.length == 1) return new int[1];
//        int[] res = new int[A.length];
//        int count;
//        for (int i = 0; i < A.length; i++) {
//            count = 0;
//            int curInt = A[i];
//            for (int a : A) {
//                if (curInt % a != 0) count++;
//            }
//            res[i] = count;
//        }
//        return res;

        // O(n log n)
        int n = A.length;
        int[] counts = new int[2 * n + 1];
        int[] ans = new int[2 * n + 1];
        int[] res = new int[n];
        for (int a : A) {
            counts[a]++;
        }

        for (int i = 1; i <= 2 * n; i++) {
            int num = counts[i];
            if (num == 0) continue;

            for (int j = i; j <= 2 * n; j += i) {
                ans[j] += num;
            }
        }

        for (int i = 0; i < n; i++) {
            res[i] = n - ans[A[i]];
        }
        return res;
    }

    public static void main(String[] args) {

        int[] A = {3,1,2,3,6};
        System.out.println(Arrays.toString(solution(A)));
    }
    
}