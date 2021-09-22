package com.xjf.leetcode.linkedList;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/9/15 22:01
 */
class SortListNode {


    /**
     * 从底向上排序链表
     * @param head
     * @return
     */
    private ListNode sortListFromTopToBottom(ListNode head) {
        return sortListFromTopToBottom(head,null);
    }


    private ListNode sortListFromTopToBottom(ListNode head, ListNode tail) {
        if(head == null) return null;
        if(head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode l1 = sortListFromTopToBottom(head,slow);
        ListNode l2 = sortListFromTopToBottom(head,fast);

        return  mergeListNode(l1,l2);
    }

    private ListNode mergeListNode(ListNode l1,ListNode l2) {
        ListNode dump = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dump;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while(temp1 !=null && temp2!=null) {
            if(temp1.val > temp2.val) {
                cur.next = new ListNode(temp2.val);
                temp2 = temp2.next;
            } else {
                cur.next = new ListNode(temp1.val);
                temp1 = temp1.next;
            }
            cur = cur.next;
        }

        cur.next = temp1 !=null?temp1:temp2;
        return dump.next;

    }




}
