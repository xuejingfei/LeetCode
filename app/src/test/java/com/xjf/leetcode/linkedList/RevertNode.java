package com.xjf.leetcode.linkedList;

/**
 * Description:反转单列表
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 8/10/21 12:04 PM
 */
class RevertNode {


    /**
     * 使用动态规划
     * @param root
     * @return
     */
    private ListNode revertByDynamic(ListNode root) {
        ListNode pre = null;
        ListNode curr = root;

        while(curr !=null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    /**
     * 使用递归做法
     * @param head
     * @return
     */
    private ListNode revertByRecursive(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = revertByRecursive(head.next);
        newHead.next.next = head;
        head.next = null;
        return newHead;
    }

}
