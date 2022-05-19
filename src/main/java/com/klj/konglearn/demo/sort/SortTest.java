package com.klj.konglearn.demo.sort;

import java.util.Arrays;

public class SortTest {
    static int[] arr;
    static {
        arr = new int[]{3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7};
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        System.out.println("=======heap-sort=========");
        HeapSort heapSort = new HeapSort();
        System.out.println(Arrays.toString(heapSort.sort(arr)));;
    }

}
