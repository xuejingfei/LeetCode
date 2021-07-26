package com.xjf.leetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/7/25 10:45
 */
class CycleNode {


    /**
     * 哈希表
     * 1.时间复杂度:O(n)
     * 2.空间复杂度:O(n)
     * @param head
     * @return
     */
    public boolean hasCycleByHashSet(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head !=null) {
            if (!set.add(head)) { //如果已经包含返回false，不包含直接添加
                return true;
            }
            head = head.next;
        }
        return false;
    }


    /**
     * 快慢指针(龟兔赛跑)
     * 1.时间复杂度：O(n)
     * 2.空间复杂度：O(1)
     * @return
     */
    public boolean hasCycleByDoublePoint(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow !=fast) {
            if (fast == null || fast.next ==null) {
                return false;
            }
            slow = head.next;
            fast = head.next.next;
        }
        return true;
    }

}
