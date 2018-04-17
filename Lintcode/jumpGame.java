package com.company;
// lc 116.
public class Main {

    public static boolean canJump(int[] A) {

        // Greedy in O(N).
        if (A == null || A.length == 0) return false;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > max) return false;
            max = Math.max(max, i + A[i]);
        }
        return true;
    }
    
    public static void main(String[] args) {

        int[] A = {2,3,1,1,4};
        int[] B = {3,2,1,0,4};
        System.out.println(canJump(A));
        System.out.println(canJump(B));
    }

}