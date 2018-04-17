package com.company;

import java.util.Stack;

public class Main {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public Main() {
        // do intialization if necessary
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

//    public void s2ToS1() {
    private void s2ToS1() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    public void push(int element) {
        // write your code here
        s1.push(element);
    }

    public int pop() {
        // write your code here
        if (!s2.isEmpty()) {
            // s2.pop();
            return s2.pop();
        } else {
//            while (!s1.isEmpty()) {
//                s2.push(s1.pop());
//            }
            this.s2ToS1();

            return s2.pop();
        }
        // return s2.pop();
    }

    public int top() {
        // write your code here
        if (!s2.isEmpty()) {
            // s2.peek();
            return s2.peek();
        } else {
//            while (!s1.isEmpty()) {
//                s2.push(s1.pop());
//            }
            s2ToS1();

            return s2.peek();
        }
        // return s2.peek();
    }

    public static void main(String[] args) {

        System.out.println();

    }
}