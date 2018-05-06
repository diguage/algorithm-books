package com.diguage.algorithm.codinginterviews.print_list_in_reversed_order;

/**
 * 从尾到头打印链表
 * <p>
 * 输入一个链表的头结点，从尾到头打印出每个结点的值
 * <p>
 * 解决方案一：首先遍历链表的节点后打印，典型的“后进先出”，可以使用栈来实现这种顺序。
 * <p>
 * 解决方案二：栈的本质就是递归，直接使用递归的方式，打印一个节点的时候先打印它后面的节点，再打印该节点自身，实现反向打印
 * <p>
 * 解决方案三：遍历链表，把链表中的元素复制到ArrayList中，然后逆序打印ArrayList中的元素
 * <p>
 * 解决方案四：前三种解决方案本身属于在打印链表的时候不修改链表本身结构，
 * <p>
 * 在允许修改链表结构的情况下可以把链表中的节点指针反转过来，改变链表方向，然后重新遍历打印改变方向后的链表
 * <p>
 * D瓜哥注：
 * 这里实用递归来解决最有启发性。
 *
 * @author D瓜哥, https://www.diguage.com/
 */
public class PrintListInReversedOrder {
    private static class Node {
        int value;
        Node next;
    }

    public static void printListInReversedOrderRescursively(Node header) {
        if (null != header) {
            if (null != header.next) {
                printListInReversedOrderRescursively(header.next);
            }
            System.out.println(header.value);
        }
    }
}
