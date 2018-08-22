package com.diguage.algorithm.codinginterviews.string_path_in_matrix;

import java.util.Stack;

/**
 * 请设计一个函数，用来推断在一个矩阵中是否存在一条包括某字符串全部字符的路径。
 * 路径能够从矩阵中随意一格開始。每一步能够在矩阵中间向左、右、上、下移动一格。
 * 假设一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * <p>
 * 比如在以下的3*4的矩阵中包括一条字符串”bfced”的路径。
 * <p>
 * 但矩阵中不包括字符串“abcb”的路径，因为字符串的第一个字符b占领了矩阵中的第一行第二格子之后，路径不能再次进入这个格子。
 * <p>
 * a b c e
 * s f c s
 * a d e e
 *
 * @author D瓜哥, https://www.diguage.com/
 */
public class StringPathInMatrix {

    public static class Point {
        int x;
        int y;
    }

    public static boolean hasPath(char[][] matrix, String string) {
        boolean result = false;
        if (null == matrix
                || matrix.length == 0 || matrix[0].length == 0
                || string == null || string.length() == 0) {
            return result;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                visited[i][j] = false;
            }
        }

        char[] chars = string.toCharArray();
        int visitedCharIndex = 0;
        Point point = null;
        matrixLoop:
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == chars[0]) {
                    ++visitedCharIndex;
                    visited[i][j] = true;
                    point = new Point();
                    point.x = i;
                    point.y = j;
                    break matrixLoop;
                }
            }
        }

        if (visitedCharIndex == 0) {
            return result;
        }

        Stack<Point> backtrackingPoints = new Stack<>();
        // TODO

        return result;
    }
}
