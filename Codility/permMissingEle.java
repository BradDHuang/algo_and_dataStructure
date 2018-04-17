package com.company;

//  A zero-indexed array A consisting of N different integers is given.
//        The array contains integers in the range [1..(N + 1)],
//        which means that exactly one element is missing.

public class Main {

    public static int missingEle(int[] A) {
        // write your code in Java SE 8

        if (A.length == 0) return 1;
        int sum = 0, missing = 0;
        for (int i = 1; i <= A.length + 1; i++) {
            sum += i;
        }
        for (int i = 0; i < A.length; i++) {
            sum -= A[i];
            missing = sum;
        }
        return missing;
        
    }

    public static void main(String[] args) {

        int[] A = {2,3,1,5};
        System.out.println(missingEle(A));

    }

}