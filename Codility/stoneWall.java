package com.company;

import java.util.Stack;

public class Main {

    public static int solution(int[] H) {
        // write your code in Java SE 8

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < H.length; i++) {
            while (!stack.isEmpty() && stack.peek() > H[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(H[i]);
                count++;
            } else {
                if (stack.peek() < H[i]) {
                    stack.push(H[i]);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] A = {8,8,5,7,9,8,7,4,8};
        System.out.println(solution(A));
    }

}