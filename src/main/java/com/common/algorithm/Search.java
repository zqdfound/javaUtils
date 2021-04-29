package com.common.algorithm;

import java.util.Arrays;

/**
 * @author zhuangqingdian
 * @date 2021/4/29
 */
public class Search {

    //二分查找,数组必须是有序的
    public static int binarySearch(int[] array, int n) {
        if (array.length == 0) {
            return -1;
        }
        int left = 0;//左节点
        int right = array.length - 1;//右节点
        while (left <= right) {
            int mid = (right + left) / 2;
            if (array[mid] == n) {
                return mid;
            } else if (array[mid] < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //冒泡排序
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    //插入排序
    public static int[] insertSort(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            int insertValue = array[i];
            int index = i - 1;//插入的位置
            while (index >= 0 && insertValue < array[index]) {
                //右移
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = insertValue;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 3, 41, 7};
        insertSort(array);
    }


}
