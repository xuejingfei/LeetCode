package com.xjf.leetcode.linkedList;

public class RemoveNthFromEnd {

    /**
     * 删除倒数第K个节点
     *
     * @param head
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n+1; i++) fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
