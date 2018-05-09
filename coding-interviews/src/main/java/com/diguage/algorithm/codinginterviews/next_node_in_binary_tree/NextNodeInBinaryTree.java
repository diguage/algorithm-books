package com.diguage.algorithm.codinginterviews.next_node_in_binary_tree;


/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author D瓜哥, https://www.diguage.com/
 */
public class NextNodeInBinaryTree {

    public static class BinaryTreeNode extends com.diguage.algorithm.codinginterviews.tree.BinaryTreeNode<String> {
        public BinaryTreeNode() {
        }

        public BinaryTreeNode(String value) {
            super(value);
        }

        BinaryTreeNode parent;
    }

    public static BinaryTreeNode getNext(BinaryTreeNode node) {
        BinaryTreeNode result = null;
        if (null == node) {
            return result;
        }

        // 有右树
        if (null != node.right) {
            BinaryTreeNode right = (BinaryTreeNode) node.right;
            while (null != right.left) {
                right = (BinaryTreeNode) right.left;
            }
            result = right;
        } else if (null != node.parent) {
            // 右树为空，并且还是父节点的右树，只能向上找父节点
            BinaryTreeNode current = node;
            BinaryTreeNode parent = node.parent;
            if (null != parent.parent && current == parent.right) {
                current = parent;
                parent = parent.parent;
            }
            if (null != parent.parent) {
                result = parent.parent;
            } else {
                result = parent;
            }

            // TODO 还需要再测试
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeNode tree = new BinaryTreeNode("a");

        BinaryTreeNode b = new BinaryTreeNode("b");
        b.parent = tree;
        tree.left = b;

        BinaryTreeNode d = new BinaryTreeNode("d");
        b.left = d;
        d.parent = b;

        BinaryTreeNode e = new BinaryTreeNode("e");
        e.parent = b;
        b.right = e;

        BinaryTreeNode h = new BinaryTreeNode("h");
        h.parent = e;
        e.left = h;

        BinaryTreeNode i = new BinaryTreeNode("i");
        i.parent = e;
        e.right = i;

        BinaryTreeNode c = new BinaryTreeNode("c");
        c.parent = tree;
        tree.right = c;

        BinaryTreeNode f = new BinaryTreeNode("f");
        f.parent = c;
        c.left = f;

        BinaryTreeNode g = new BinaryTreeNode("g");
        g.parent = c;
        c.right = g;

        tree.printMidorder();

        System.out.println(getNext(tree).value);
        System.out.println(getNext(b).value);
        System.out.println(getNext(i).value);
        System.out.println(getNext(g).value);

    }
}
