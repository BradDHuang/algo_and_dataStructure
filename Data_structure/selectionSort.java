package com.company;

// ***Selection Sort***

public class selectionSort {

    public static int[] selectionSort(int[] arr) {
        int tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {

                    tmp = arr[i];

                    arr[i] = arr[j];
                    
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        // write your code here

        int[] arr = {1, 2, 5, -3, 4, 1, -10};
        int[] newarr = selectionSort(arr);
        System.out.print(newarr[0] + " ");
        System.out.print(newarr[1] + " ");
        System.out.print(newarr[2] + " ");
        System.out.print(newarr[3] + " ");
        System.out.print(newarr[4] + " ");
        System.out.print(newarr[5] + " ");
        System.out.print(newarr[6] + " ");
    }

}