package com.xjf.leetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 8/16/21 4:05 PM
 */
class GetIntersectionNode {


    /**
     * 暴力法
     *
     * @param headA,headB
     * @return
     */
    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        while (tempA != null) {
            ListNode tempB = headB;
            while (tempB != null) {
                if (tempA == tempB) {
                    return tempA;
                }
                tempB = tempB.next;
            }
            tempA = tempA.next;
        }
        return null;
    }


    /**
     * 使用hashSet
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param headA
     * @param headB
     * @return
     */
    private ListNode getIntersectionNodeBySet(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet();
        ListNode tempA = headA;
        while (tempA != null) {
            set.add(headA);
            tempA = tempA.next;
        }

        ListNode tempB = headB;
        while (tempB != null) {
            if (set.contains(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }


    /**
     * 空间复杂度O(1)
     * 时间复杂度O(n)
     * @param headA
     * @param headB
     * @return
     */
    private ListNode getIntersectionNodeBy(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }

}
