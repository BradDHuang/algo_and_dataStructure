package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static ArrayList findOptimalWeights(double capacity, double[] weights, int numOfContainers) {
        int len = weights.length;
        int start = 0, end = len - 1;
        ArrayList<Double> res = new ArrayList<>();
        int resIdx1 = 0, resIdx2 = len - 1;
        double closest = 0;
        Arrays.sort(weights);
        while (start < end) {
            double sum = weights[start] + weights[end];
            if (sum > closest && sum <= capacity) {
                closest = sum;
                resIdx1 = start;
                resIdx2 = end;
            }
            if (sum > capacity) {
                end--;
            } else start++;

        }
        res.add(weights[resIdx1]);
        res.add(weights[resIdx2]);
        return res;
    }

    public static void main(String[] args) {
        double[] weights = {2.3, 3.2, 10.1, 9, 8.9};
        ArrayList<Double> res = findOptimalWeights(12.23, weights, 5);
        System.out.println(res.get(0)); // 3.2
        System.out.println(res.get(1)); // 9.0
    }

}


