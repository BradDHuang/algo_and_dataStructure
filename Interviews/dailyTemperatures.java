package com.company;

// LC 739. Daily Temperatures
//  Given a list of daily temperatures, produce a list that,
//        for each day in the input, tells you how many days you would have to wait until a warmer temperature.
//        If there is no future day for which this is possible, put 0 instead.
//        For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73],
//                             your output should be [ 1,  1,  4,  2,  1,  1,  0, 0 ].
// Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < res.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(temperatures);

//        StringBuilder sb = new StringBuilder();
//        for (int i : res) {
//            sb.append(i);
//        }
//        System.out.println(sb);

//        for (int i : res) {
//      if you need to use i.remove(); in your loop,
//      or access the actual iterator in some way, eg. (res[i])
//      you cannot use the for ( : ) idiom, since the actual iterator is merely inferred.
//        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i]);
//        }

        System.out.println(Arrays.toString(res));

    }
}