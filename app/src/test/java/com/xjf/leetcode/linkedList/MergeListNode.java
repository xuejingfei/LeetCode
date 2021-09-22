package com.xjf.leetcode.linkedList;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/9/15 15:26
 */
class MergeListNode {

    /**
     * 合并两个单链表
     * @param headA
     * @param headB
     * @return
     */
    private ListNode mergeList(ListNode headA,ListNode headB) {
        ListNode dum = new ListNode(-200);
        ListNode cur = dum;
        while(headA !=null && headB !=null) {
            if(headA.val > headB.val) {
                cur.next = new ListNode(headB.val);
                headB = headB.next;
            } else {
                cur.next = new ListNode(headA.val);
                headA = headA.next;
            }
            cur = cur.next;
        }
        cur.next = headA != null?headA:headB;
        return dum.next;
    }
}
