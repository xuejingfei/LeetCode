package com.xjf.leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 8/16/21 3:37 PM
 */
class HasRecycle {

    /**
     * 判断是否有环
     * @param head
     * @return
     */
    private boolean hasRecycleBySet(ListNode head) {
        Set<ListNode> set = new HashSet();
        while(head !=null) {
            if(!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


    /**
     * 龟兔赛跑
     * @param head
     * @return
     */
    private boolean hasRecycleByPoint(ListNode head) {
        if(head == null || head.next ==null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            if(fast == null || fast.next ==null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
