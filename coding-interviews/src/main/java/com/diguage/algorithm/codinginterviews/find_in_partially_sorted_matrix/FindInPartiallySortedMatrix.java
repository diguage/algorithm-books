package com.diguage.algorithm.codinginterviews.find_in_partially_sorted_matrix;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author D瓜哥, https://www.diguage.com/
 */
public class FindInPartiallySortedMatrix {
    public static boolean find(int[][] matrix, int number) {
        boolean found = false;
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return found;
        }

        if (number < matrix[0][0]
                || number > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return found;
        }
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == number) {
                found = true;
                break;
            } else if (matrix[row][column] > number) {
                --column;
            } else {
                ++row;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find(matrix, 20));
    }
}
