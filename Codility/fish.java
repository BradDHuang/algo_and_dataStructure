package com.company;

import java.util.Stack;

public class Main {

    public static int solution(int[] A, int[] B) {
        // write your code in Java SE 8

        if (A == null || B == null || A.length != B.length) return -1;
        if (A.length <= 1 && B.length <= 1) return A.length;
        
        Stack<Integer> stack = new Stack<>();
        int fish = 0;
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 0) {
                while (!stack.isEmpty()) {
                    if (stack.peek() > A[i]) {
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if (stack.isEmpty()) fish++;
            }
            if (B[i] == 1) {
                stack.push(A[i]);
            }
        }
        fish += stack.size();
        return fish;
    }

    public static void main(String[] args) {

        int[] A = {4,3,2,1,5};
        int[] B = {0,1,0,0,0};
        System.out.println(solution(A, B));

    }

}