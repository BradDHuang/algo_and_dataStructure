package com.company;

public class Main {

    public static int solution(int[] A) {
        // write your code in Java SE 8

        // O(n) time, O(1) space.
        if (A == null || A.length == 0) return -1;
//        if (A.length == 1) return A[0];
        if (A.length == 1) return 0; // return idx!

        int domVal = A[0];
        int domIdx = 0;
        int domCnt = 1;
        // 如果dom 存在，那么只可能是：eg. [2,3,3] or [3,2,3]（要么有相邻的情况，要么有一个在最右/后）。
        for (int i = 1; i < A.length; i++) {
            if (A[i] == domVal) domCnt++;
            else domCnt--;
            if (domCnt == 0) {
                domVal = A[i];
                domIdx = i;
                domCnt = 1;
            }
        }

        // check the updated domVal
        domCnt = 0;
        for (int a : A) {
           if (a == domVal) domCnt++;
        }
        if (domCnt <= A.length / 2) return -1;
        else return domIdx;
    }

    public static void main(String[] args) {

        int[] A = {2147483647};
        System.out.println(solution(A));
    }
    
}