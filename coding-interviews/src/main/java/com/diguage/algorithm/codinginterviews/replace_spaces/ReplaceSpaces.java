package com.diguage.algorithm.codinginterviews.replace_spaces;

import java.util.Arrays;

/**
 * 请实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如输入“We are happy.”，则输出“We%20are%20happy.”。
 * <p>
 * 注：这道题更实用没有字符串表示的语言中，比如 C，在 Java 中只能实用 <code>char</code> 数组模拟。
 *
 * @author D瓜哥, https://www.diguage.com/
 */
public class ReplaceSpaces {
    public static void replace(char[] string) {
        if (null == string || string.length == 0) {
            return;
        }

        int originalLength = 0;
        int numberOfBlank = 0;
        for (int i = 0; i < string.length && string[i] != '\0'; i++) {
            ++originalLength;
            if (string[i] == ' ') {
                ++numberOfBlank;
            }
        }
        int newLength = originalLength + numberOfBlank * 2;
        if (newLength > string.length) {
            return;
        }
        int indexOfOriginal = originalLength - 1;
        int indexOfNew = newLength - 1;
        while (0 <= indexOfOriginal && indexOfOriginal <= indexOfNew) {
            if (string[indexOfOriginal] == ' ') {
                string[indexOfNew--] = '0';
                string[indexOfNew--] = '2';
                string[indexOfNew--] = '%';
            } else {
                string[indexOfNew--] = string[indexOfOriginal];
            }
            --indexOfOriginal;
        }
    }

    public static void main(String[] args) {
        char[] string = "We are happy\0      ".toCharArray();
        replace(string);
        System.out.println(Arrays.toString(string));
    }
}
