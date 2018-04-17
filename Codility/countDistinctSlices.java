package com.company;

import java.util.HashSet;

public class Main {

    public static int solution(int M, int[] A) {
        // write your code in Java SE 8

        // O(n * (n + M)), 100% + 40%(TimeOut!)
//        if (A.length == 1) return 1;
//        int start = 0, end = 0;
//        HashSet<Integer> set = new HashSet<>();
//        int count = 0;
//        int res = 0;
//        while (end <= A.length - 1) {
//            set.add(A[end]);
//            int newCnt = set.size();
//            if (count == newCnt) {
//                res += count;
//                start++;
//                end = start;
//                set.clear();
//                count = 0;
//            } else {
//                count = newCnt;
//                if (end == A.length - 1) {
//                    res += count;
//                    start++;
//                    end = start;
//                    set.clear();
//                    count = 0;
//                } else {
//                    end++;
//                }
//            }
//        }
//        return res;

        //  标记！
        // O(n)
        int N = A.length;
        int sum = 0;
        int start = 0, end = 0;
        int a = (int) 1e9;
        boolean[] seen = new boolean[M + 1]; // 0 ~ M.
        while (start < N && end < N) {
            while (end < N && !seen[A[end]]) {
                sum += end - start + 1;
//                System.out.println(sum);

                if (sum > a) return a; // Better performance!

                seen[A[end]] = true;
                end++;
            }
            while (start < N && end < N && A[start] != A[end]) {
                seen[A[start]] = false;
                start++;
            }
            seen[A[start]] = false;
            start++;
        }

        return Math.min(sum, a);
    }

    public static void main(String[] args) {

        int[] A = {3,4,5,5,2};
        System.out.println("res: " + solution(6, A));
        int a = (int) 1e9;
        System.out.println(a);
    }

}