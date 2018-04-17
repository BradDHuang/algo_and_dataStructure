package com.company;

import java.util.Arrays;

public class Main {

    public static int[] sortIntegers2(int[] A) {
        // write your code here

        // merge sort
        if (A == null || A.length == 0) return new int[0];

        int[] temp = new int[A.length];
        mergesort(A, 0, A.length - 1, temp);
        return A;
    }
    private static void mergesort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        mergesort(A, start, (start + end) / 2, temp);
        mergesort(A, (start + end) / 2 + 1, end, temp);
        // merge(A, start, (start + end) / 2 + 1, end, temp);
        merge(A, start, end, temp);
    }
    // private void merge(int[] A, int leftstart, int rightstart, int end, int[] temp) {
    // private void merge(int[] A, int leftstart, int end, int[] temp) {
    private static void merge(int[] A, int start, int end, int[] temp) {
        int mid = (start + end) / 2;
        // int index = 0;
        int index = start;

        int leftstart = start;
        int rightstart = mid + 1;
//        int index = leftstart;

        while (leftstart <= mid && rightstart <= end) {
            if (A[leftstart] < A[rightstart]) {
                temp[index++] = A[leftstart++];
            } else {
                temp[index++] = A[rightstart++];
            }
        }
        while (leftstart <= mid) {
            temp[index++] = A[leftstart++];
        }
        while (rightstart <= end) {
            temp[index++] = A[rightstart++];
        }
        // for (int i = 0; i < A.length; i++) {
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, -2, 3, -4};
        sortIntegers2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(Arrays.toString(nums));
    }

}