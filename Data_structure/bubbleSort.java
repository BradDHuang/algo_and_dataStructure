package com.company;

public class bubbleSort {

    public static int[] bubbleSort(int[] arr) {

        boolean swapped = true;
        // 发生了交换就为true, 没发生就为false，第一次判断时必须标志为true

        int j = 0;

        int tmp;

        while (swapped) {

            swapped = false;
            // 每次开始排序前，都设置flag为未排序过

            j++;
            // 减小一次排序的尾边界

            for (int i = 0; i < arr.length - j; i++) {

                if (arr[i] > arr[i + 1]) {

                    tmp = arr[i];

                    arr[i] = arr[i + 1];

                    arr[i + 1] = tmp;

                    swapped = true;
                    // 表示交换 *** 过！ *** 数据

                }

            }

        }

        return arr;
    }

    public static void main(String[] args) {
        // write your code here

        int[] arr = {1, 2, 3, 4, 3, 2, 1};
        int[] newarr = bubbleSort(arr);
        System.out.print(newarr[0] + " ");
        System.out.print(newarr[1] + " ");
        System.out.print(newarr[2] + " ");
        System.out.print(newarr[3] + " ");
        System.out.print(newarr[4] + " ");
        System.out.print(newarr[5] + " ");
        System.out.print(newarr[6] + " ");
    }

}