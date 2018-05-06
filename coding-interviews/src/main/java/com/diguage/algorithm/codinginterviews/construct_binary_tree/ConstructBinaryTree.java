package com.diguage.algorithm.codinginterviews.construct_binary_tree;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建出如下图所示的二叉树并输出它的头结点。
 * //          1
 * //       /     \
 * //      2       3
 * //     /       / \
 * //    4       5   6
 * //     \         /
 * //      7       8
 * <p>
 * 注释：TODO 如果有重复数字的该怎么办？
 *
 * @author D瓜哥, https://www.diguage.com/
 */
public class ConstructBinaryTree {
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static BinaryTreeNode construct(int[] preorder, int[] midorder) {
        if (preorder.length != midorder.length
                || null == preorder || preorder.length == 0
                || null == midorder || midorder.length == 0) {
            return null;
        }

        return findRoot(
                preorder, 0,
                midorder, 0,
                preorder.length);
    }

    public static BinaryTreeNode findRoot(int[] preorder, int preorderStart,
                                          int[] midorder, int midorderStart,
                                          int length) {
        if (preorderStart >= preorder.length || midorderStart >= preorder.length) {
            return null;
        }

        int rootValue = preorder[preorderStart];
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = rootValue;
        if (length <= 1) {
            return root;
        } else {
            // 确定 root 的index
            int index = -1;
            for (int i = midorderStart; i < (midorderStart + length); i++) {
                if (midorder[i] == rootValue) {
                    index = i;
                    break;
                }
            }
            // 先找左树
            int childLeftPreStart = preorderStart + 1;
            int childLeftMidStart = midorderStart;
            int childLeftLength = index - midorderStart;

            if (childLeftLength > 0) {
                BinaryTreeNode left = findRoot(
                        preorder, childLeftPreStart,
                        midorder, childLeftMidStart,
                        childLeftLength);
                root.left = left;
            }


            // 后找右树
            int childRightPreStart = preorderStart + childLeftLength + 1;
            int childRightMidStart = index + 1;
            int childRightLength = midorderStart + length - index - 1;
            if (childRightLength > 0) {
                BinaryTreeNode right = findRoot(
                        preorder, childRightPreStart,
                        midorder, childRightMidStart,
                        childRightLength);
                root.right = right;
            }
            return root;
        }
    }

    public static void printSuforderTree(BinaryTreeNode root) {
        if (null == root) {
            return;
        }
        printSuforderTree(root.left);
        printSuforderTree(root.right);
        System.out.print(root.value + ", ");
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] midorder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode tree = construct(preorder, midorder);
        printSuforderTree(tree);
    }
}
