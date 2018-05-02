package com.company;

// leetcode 371. Sum of Two Integers // lc 1. A + B Problem
//Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

public class Main {

    public static int getSum(int a, int b) {

//        主要利用异或运算来完成
        // 异或运算有一个别名叫做：不进位加法
        // 那么a ^ b就是a和b相加之后，该进位的地方不进位的结果
        // 然后下面考虑哪些地方要进位，自然是a和b里都是1的地方
        // a & b就是a和b里都是1的那些位置，a & b << 1 就是进位之后的结果。
        // 所以：a + b = (a ^ b) + ((a & b) << 1)
        // 令a' = a ^ b, b' = (a & b) << 1
        // 可以知道，这个过程是在模拟加法的运算过程，进位不可能一直持续，所以b最终会变为0。
        // 因此重复做上述操作就可以求得a + b的值。
        while (b != 0) {
            int xa = a ^ b;
            int xb = (a & b) << 1;
            a = xa;
            b = xb;
        }
        return a;
    }

    public static void main(String[] args) {

        System.out.println(getSum(2, 2));
        System.out.println(1 ^ 1); // 0
        System.out.println((1 & 1) << 1); // 2
        System.out.println(1 & 1 << 1); // 0, << 优先级高！
    }

}