package com.xjf.leetcode.linkedList;

import java.util.LinkedList;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 8/28/21 10:56 AM
 */
class GetKNodeFromList {


    /**
     * 通过队列
     *
     * @param head
     * @param k
     * @return
     */
    private ListNode getKNodeFromListByQueue(ListNode head, int k) {
        LinkedList<ListNode> queue = new LinkedList();
        while (head != null) {
            if (queue.size() == k) {
                queue.pop();
            }
            queue.offer(head);
            head = head.next;
        }
        return queue.pop();
    }

    /**
     * 取单链表倒数第K的节点
     *
     * @param head
     * @param k
     * @return
     */
    private ListNode getKNodeFromListByPoint(ListNode head, int k) {
        ListNode head1 = head;
        ListNode head2 = head;
        for (int i = 0; i <= k; i++) {
            head1 = head1.next;
        }

        while (head1.next != null) {
            head2 = head2.next;
            head1 = head1.next;
        }
        return head2;
    }
}
