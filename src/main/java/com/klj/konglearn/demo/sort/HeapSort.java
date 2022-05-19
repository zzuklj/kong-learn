package com.klj.konglearn.demo.sort;

import java.util.Arrays;

import static com.klj.konglearn.demo.sort.SwapTool.swap;

public class HeapSort {

    public int[] sort(int[] sourceArr){
        int length = sourceArr.length;
        int[] arr = Arrays.copyOf(sourceArr, length);

        //构建初始化最大堆
        buildMaxHeap(arr);

        //将最大堆根元素与最后一个元素互换，
        // 然后对新堆元素（排除最后一个元素）做最大堆构建
        //重复替换和最大堆构建
        for( int i = length - 1; i > 0; i--){
            swap(arr, 0, i);
            length--;
            heapify(arr, 0, length);
        }

        return arr;

    }

    //构建最大堆
    private void buildMaxHeap(int[] arr) {
         int startIndex = (int) Math.floor(arr.length / 2);
         for(int i = startIndex; i >= 0; i--){
             heapify(arr, i, arr.length);
         }
    }

    private void heapify(int[] arr, int startIndex, int endIndex) {
        int left = 2*startIndex + 1;
        int right = 2*startIndex + 2;
        int largest = startIndex;

        if(left < endIndex && arr[left] > arr[largest]) largest = left;
        if(right < endIndex && arr[right] > arr[largest]) largest = right;

        if(largest != startIndex){
            swap(arr, startIndex , largest);
            heapify(arr, largest, endIndex);
        }
    }

}
