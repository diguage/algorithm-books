package com.diguage.algorithm.codinginterviews.duplication_number_in_array;

/**
 * 不修改数组找出重复的数字。
 * <p>
 * 在一个长度为n+1的数组里的所有数字都在1~n的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但是不能修改输入的数组。例如，如果输入长度为 8 的
 * 数组 {2,3,5,4,3,2,6,7}，那么对应的输出是重复的数字2或者3。
 *
 * @author D瓜哥, https://www.diguage.com/
 */
public class DuplicationNumberInArrayNoEdit {
    public static int getDuplication(int[] numbers) {
        if (null == numbers || numbers.length <= 0) {
            return -1;
        }
        int start = 0;
        int end = numbers.length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(numbers, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = start + 1;
            }
        }
        return -1;
    }

    private static int countRange(int[] numbers, int start, int end) {
        if (null == numbers) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (start <= numbers[i] && numbers[i] <= end) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(getDuplication(numbers));
    }
}
