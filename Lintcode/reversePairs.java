package com.company;

// LC 532. Reverse Pairs

public class Main {

    public static long reversePairs(int[] A) {
        // Write your code here
        int[] temp = new int[A.length];
        // automatically cast to long
        return mergeSort(A, 0, A.length -1, temp);
    }
    private static int mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return 0;
        }
        int sum = 0;
        int mid = start + (end - start)/2;
        sum += mergeSort(A, start, mid, temp);
        sum += mergeSort(A, mid + 1, end, temp);
        sum += merge(A, start, end, temp);
        return sum;
    }
    private static int merge(int[] A, int start, int end, int[] temp) {
        int sum = 0;
        int mid = start + (end - start)/2;
        int leftIndex = start;
        int rightIndex = mid + 1;
        int index = start;
        while (leftIndex <= mid && rightIndex <= end) {
            if (A[leftIndex] <= A[rightIndex]) {
                temp[index++] = A[leftIndex++];
            } else {
//                在归并的过程中(leftIndex, mid),(rightIndex, end)这两个区间内的元素都是有序的（升序），
//                如果出现A[leftIndex] > A[rightIndex]的情况，
//                那么从leftIndex开始到mid的所有元素都是大于A[rightIndex]的，
//                也就是说有mid - leftIndex + 1个逆序对。
                temp[index++] = A[rightIndex++];
                sum += mid - leftIndex + 1;
            }
        }
        while (leftIndex <= mid) {
            temp[index++] = A[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[index++] = A[rightIndex++];
        }
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        // write your code here
        int[] A = new int[]{1, 3, 2, 5, 4, 4, 2};
//        reversePairs(A);
        System.out.print(reversePairs(A));
    }
}