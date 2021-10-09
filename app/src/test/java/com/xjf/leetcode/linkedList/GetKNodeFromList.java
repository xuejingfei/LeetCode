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
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
