package com.company;

// lc 12. Min Stack

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;
    public MinStack() {
        // do initialization if necessary

        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (min.isEmpty()) {
            min.push(number);
        } else {
//            if (number == min.peek()) {
//                min.push(number);
//            }
//            if (number < min.peek()) {
//                min.pop();
//                min.push(number);
//            }

            if (number <= min.peek()) {
                min.push(number);
            }
        }
    }

    public int pop() {
        // write your code here
        int res = stack.pop();

        if (!min.isEmpty()) { // to avoid EmptyStackException!
            if (res == min.peek()) {
                min.pop();
            }
        }
        return res;
    }

    public int min() {
        // write your code here
//        return min.pop();
        return min.peek();
    }

    public static void main(String[] args) {

        MinStack s = new MinStack();
        s.push(3);
        s.push(2);
        s.push(1);
        System.out.println(s.min()); // return 1
        System.out.println(s.pop()); // return 1
        System.out.println(s.min()); // return 2
        System.out.println(s.pop()); // return 2
        System.out.println(s.min()); // return 3

//        Integer x = 128;
//        Integer y = 128;
//        System.out.println(x == y); // 进行地址及数值比较! // false

        // -128 ~ 127
//        Integer x2 = 127;
//        Integer y2 = 127;
//        System.out.println(x2 == y2); // 只进行(int 原生数据类型的)数值比较 // true
    }

}