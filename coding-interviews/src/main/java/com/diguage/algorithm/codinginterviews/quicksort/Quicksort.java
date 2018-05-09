package com.diguage.algorithm.codinginterviews.quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 *
 * @author D瓜哥, https://www.diguage.com/
 */
public class Quicksort {

    public static int partition(int[] data, int start, int end) {
        if (null == data || start < 0 | end >= data.length | end < start) {
            return -1;
        }
        Random random = new Random();
        int index = random.nextInt(end - start) + start;
        swap(data, index, end);

        int small = start - 1;
        // 这种写法还是第一次见，值得学习
        for (index = start; index < end; index++) {
            if (data[index] < data[end]) {
                ++small;
                if (index != small) {
                    swap(data, index, small);
                }
            }
        }
        ++small;
        swap(data, small, end);
        return small;
    }

    public static void quicksort(int[] data, int start, int end) {
        if (start == end) {
            return;
        }
        int partition = partition(data, start, end);
        if (start < partition) {
            quicksort(data, start, partition - 1);
        }
        if (partition < end) {
            quicksort(data, partition + 1, end);
        }
    }

    public static void quicksort(int[] data) {
        quicksort(data, 0, data.length - 1);
    }

    private static void swap(int[] data, int first, int second) {
        int temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 4, 7, 3, 9, 5, 6, 8};
        quicksort(data);
        System.out.println(Arrays.toString(data));
    }
}
