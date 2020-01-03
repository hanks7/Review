package com.easyway.review;

import com.hanks.frame.utils.Ulog;

import java.util.Arrays;

/**
 * @author 侯建军 QQ:474664736
 * @time 2020/1/3 9:59
 * @class describe
 */
public class Test {
    /**
     * 冒泡排序
     * @param arr
     * @return
     */
    public static int[] bubbleSort1(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                try {
                    Ulog.o(Arrays.toString(arr));
                    Ulog.o("j", j);
                    Ulog.o("i", i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return arr;
    }

    /**
     * 选择排序
     * @param arr
     * @return
     */
    public static int[] bubbleSort2(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                try {
                    Ulog.o(Arrays.toString(arr));
                    Ulog.o("j", j);
                    Ulog.o("i", i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return arr;
    }


    public static void main(String[] args) {

        Ulog.o("最终结果", Arrays.toString(bubbleSort2(new int[]{5, 4, 3, 2, 1})));
        Ulog.o("最终结果", Arrays.toString(bubbleSort1(new int[]{5, 4, 3, 2, 1})));

    }
}
