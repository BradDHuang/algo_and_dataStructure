package com.company;

// lc 424.

import java.util.Stack;

public class Main {

    public static int evalRPN(String[] tokens) {

        if (tokens == null || tokens.length == 0) return 0;
        if (tokens.length == 1) return Integer.valueOf(tokens[0]);
        Stack<String> stack = new Stack<>();
        stack.push(tokens[0]);
        stack.push(tokens[1]);
        for (int i = 2; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                String a = stack.pop();
                String b = stack.pop();
                int c = Integer.valueOf(a) + Integer.valueOf(b);
                stack.push("" + c);
            } else if (tokens[i].equals("-")) {
                String a = stack.pop();
                String b = stack.pop();
//                int c = Integer.valueOf(a) - Integer.valueOf(b);
                int c = Integer.valueOf(b) - Integer.valueOf(a);
                stack.push("" + c);
            } else if (tokens[i].equals("*")) {
                String a = stack.pop();
                String b = stack.pop();
                int c = Integer.valueOf(a) * Integer.valueOf(b);
                stack.push("" + c);
            } else if (tokens[i].equals("/")) {
                String a = stack.pop();
                String b = stack.pop();
//                int c = Integer.valueOf(a) / Integer.valueOf(b);
                int c = Integer.valueOf(b) / Integer.valueOf(a);
                stack.push("" + c);
            } else {
                stack.push(tokens[i]);
            }
        }
        String res = stack.pop();
        return Integer.valueOf(res);
        
        // modified version. push Integer into Stack!
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {

        String[] A = {"2", "1", "+", "3", "*"}; // -> ((2 + 1) * 3) -> 9
        String[] B = {"4", "13", "5", "/", "-"}; // -> (4 - (13 / 5)) -> 2
        System.out.println(evalRPN(A));
        System.out.println(evalRPN(B));
        System.out.println(evalRPN(new String[]{"18"}));
    }

}