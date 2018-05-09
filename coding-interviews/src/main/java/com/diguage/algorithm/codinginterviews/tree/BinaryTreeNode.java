package com.diguage.algorithm.codinginterviews.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 基本的树结构
 *
 * @param <T>
 * @author D瓜哥, https://www.diguage.com/
 */
public class BinaryTreeNode<T> {
    public T value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public List<T> preorder() {
        List<T> result = new LinkedList<>();
        preorder(this, result);
        return new ArrayList<>(result);
    }

    public void printPreorder() {
        printTree(preorder());
    }

    private void preorder(BinaryTreeNode<T> node, List<T> values) {
        if (null != node.value) {
            values.add(node.value);
        }
        if (null != node.left) {
            preorder(node.left, values);
        }
        if (null != node.right) {
            preorder(node.right, values);
        }
    }

    public List<T> midorder() {
        List<T> result = new LinkedList<>();
        midorder(this, result);
        return new ArrayList<>(result);
    }

    public void printMidorder() {
        printTree(midorder());
    }

    private void midorder(BinaryTreeNode<T> node, List<T> values) {
        if (null != node.left) {
            midorder(node.left, values);
        }
        if (null != node.value) {
            values.add(node.value);
        }
        if (null != node.right) {
            midorder(node.right, values);
        }
    }


    public List<T> suforder() {
        List<T> result = new LinkedList<>();
        suforder(this, result);
        return new ArrayList<>(result);
    }

    public void printSuforder() {
        printTree(suforder());
    }

    private void suforder(BinaryTreeNode<T> node, List<T> values) {
        if (null != node.left) {
            suforder(node.left, values);
        }

        if (null != node.right) {
            suforder(node.right, values);
        }

        if (null != node.value) {
            values.add(node.value);
        }
    }

    private void printTree(List<T> values) {
        T[] objects = (T[]) values.toArray();
        System.out.println(Arrays.toString(objects));
    }
}
