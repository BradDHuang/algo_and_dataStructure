package com.company;

// We have N^2 (i,j) pairs, but we only care about those where j > i,
// That means we have to eliminate all pairs where (j <= i).
// Say you have the list [x_1,x_2,x_3,...,x_k],
// you want to eliminate the tuples {(x_1,x_1),(x_1,x_2),(x_1,x_3),...(x_1,x_n)} for x_1. There is N of those.
// For x_2, you have (N-1). For x_k, you only have to ignore x_k, so 1 pair.
// You get N + (N-1) + (N-2) + ... + 1 tuples you have to eliminate – this is known to be N(N+1)/2.

import java.util.Arrays;

public class 2sum {

    public static int solution(int[] A) {
        // write your code in Java SE 8

        // intersect: j - i <= A[i] + A[j], that is, A[i] + i >= -(A[j] - j).
        if (A == null || A.length == 0) return 0;
        long[] a = new long[A.length];
        long[] b = new long[A.length];
        for (int i = 0; i < A.length; i++) {
            a[i] = (long) A[i] + i;
            b[i] = -((long) A[i] - i);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        long count = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            int pos = Arrays.binarySearch(b, a[i]);
            // If the array contains multiple elements with the specified value, there is no guarantee which one will be found.
            // Returns index of the search key, if it is contained in the array;
            // otherwise, (-(insertion point) - 1). The insertion point is defined as the point
            // at which the key would be inserted into the array:
            // the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key.
            // Note that this guarantees that the return value will be >= 0 if and only if the key is found.
            if (pos >= 0) {
                while (pos < a.length && b[pos] == a[i]) {
                    pos++; // until b[pos] > a[i]
                }
                count += pos;
            } else {
                int insertionPoint = -(pos + 1);
                count += insertionPoint;
            }
//            if (count > 1e7) return -1;
        }
        long sub = (long)A.length * ((long)A.length + 1)/2; // Notes on the top.
        count -= sub;

        if (count > 1e7) return -1;
        return (int) count;
    }

    public static void main(String[] args) {

        int[] A = {1,5,2,1,4,0};
        System.out.println(solution(A));
    }

}