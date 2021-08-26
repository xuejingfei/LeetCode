package com.xjf.leetcode.linkedList;

import com.xjf.leetcode.LinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/7/24 20:26
 */
class IntersectionNode {

    /**
     * 暴力解法 1.O(n^2) 2.O(1  )
     */
    ListNode getIntersectionNodeByViolence(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
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
     * 使用哈希集合 1.时间复杂度：O(m+n) 2.空间复杂度：O(m)
     */
    ListNode getIntersectionNodeByHashSet(ListNode headA, ListNode headB) {
        Set<ListNode> hashSet = new HashSet<>();
        ListNode tempA = headA;
        while (tempA != null) {
            hashSet.add(tempA);
            tempA = tempA.next;
        }

        ListNode tempB = headB;
        while (tempB != null) {
            if (hashSet.contains(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }


    /**
     * 使用双指针 1.时间复杂度：O(m+n) 2.空间复杂度：O(1)
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionByDoublePoint(ListNode headA, ListNode headB) {
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
