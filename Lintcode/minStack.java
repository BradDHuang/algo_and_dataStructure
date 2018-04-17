package com.company;

// lc 12. Min Stack

import java.util.Stack;

public class Main {

    private static Stack<Integer> s1;
    private static Stack<Integer> minS;
    public Main() {
        // do intialization if necessary
        s1 = new Stack<>();
        minS = new Stack<>();
    }

    private static void push(int number) {
        // write your code here
        s1.push(number);
        if (minS.isEmpty()) {
            minS.push(number);
        } else {

            // int min = minS.peek();
            // if (number < (int)minS.peek()) { // Integer.
            if (number <= minS.peek()) { // Integer.
                minS.push(number);
            }
        }
    }

    private static void pop() {
        // write your code here
        if (!minS.isEmpty()) {
            if (minS.peek() == (int)s1.peek()) {
                minS.pop();
            }
        }
//        return s1.pop();
        System.out.println(s1.pop());
    }

    private static void min() {
        // write your code here
//        return minS.peek();
        System.out.println(minS.peek());
    }

    public static void main(String[] args) {

//        Integer x = 128;
//        Integer y = 128;
//        System.out.println(x == y); // 进行地址及数值比较! // false

        // -128 ~ 127
//        Integer x2 = 127;
//        Integer y2 = 127;
//        System.out.println(x2 == y2); // 只进行(int 原生数据类型的)数值比较 // true

        Main main = new Main();

        main.push(1);
        main.pop();   // return 1
        main.push(2);
        main.push(1);
        main.min();   // return 1
        main.push(1);
        main.min();   // return 1
    }
}