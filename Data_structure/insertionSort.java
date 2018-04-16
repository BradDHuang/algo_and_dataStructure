package com.company;

// *** insertion sort *** 
// using *** while-loop! ***

public class insertionSort {

    public static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int tmp = arr[i];

            while (j > 0 && arr[j - 1] > tmp) {
                arr[j] = arr[j - 1];

                j--;

            }
            arr[j] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) {
        // write your code here

        int[] arr = {7, -5, 4, 3, -10, 2, 0};
        int[] newarr = insertionSort(arr);
        System.out.print(newarr[0] + " ");
        System.out.print(newarr[1] + " ");
        System.out.print(newarr[2] + " ");
        System.out.print(newarr[3] + " ");
        System.out.print(newarr[4] + " ");
        System.out.print(newarr[5] + " ");
        System.out.print(newarr[6] + " ");
    }

}