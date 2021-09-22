package com.xjf.leetcode.linkedList;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 9/22/21 3:41 PM
 */
class RevertKNode {

    //反转单链表的k个节点
    public ListNode revertKListNode(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        // 定义一个假的节点
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump;
        ListNode end = dump;
        while (end.next != null) {
            //找出k个值的node节点
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            //暂存k个节点的下一个节点
            ListNode next = end.next;
            //断开节点
            end.next = null;
            //获取开始节点
            ListNode start = pre.next;
            //反转k个节点，并链接之前的节点
            pre.next = revertNode(start);
            //之前的头节点连接后面的节点
            start.next = next;
            pre = start;
            end = start;
        }
        return dump.next;
    }

    public ListNode revertNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
