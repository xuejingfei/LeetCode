package com.xjf.leetcode.linkedList;

import java.util.PriorityQueue;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/9/16 22:18
 */
class MergeKListNode {


    /**
     * 分治合并
     * 时间复杂度：O(kn*logK)
     * 空间复杂度：O(logK)
     * @param lists
     * @return
     */
    private ListNode mergeKListNode(ListNode[] lists) {
        if(lists == null || lists.length == 0)return null;
        return mergeKListNode(lists,0,lists.length-1);
    }

    private ListNode mergeKListNode(ListNode[] lists,int left,int right) {
        if(left == right) return lists[left];
        int middle = (left + right)/2;
        return mergeTwoListNode(mergeKListNode(lists,left,middle),mergeKListNode(lists,middle+1,right));
    }

    private ListNode mergeTwoListNode(ListNode list1,ListNode list2) {
        ListNode prefix = new ListNode(-1);
        ListNode cur = prefix;
        while(list1 !=null && list2 !=null) {
            if(list1.val > list2.val) {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            cur = cur.next;
        }
        cur.next = list1 !=null?list1:list2;
        return prefix.next;
    }

    class Status implements Comparable<Status> {
        int val;
        ListNode node;

        public Status(int val,ListNode node) {
            this.val = val;
            this.node = node;
        }

        @Override
        public int compareTo(Status status2) {
            return this.val - status2.val ;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<>();

    private ListNode mergeKListNodeByPriority(ListNode[] lists) {
        for(ListNode node:lists) {
            if(node !=null) {
                queue.offer(new Status(node.val,node));
            }
        }

        ListNode prefix = new ListNode(0);
        ListNode cur = prefix;
        while(!queue.isEmpty()) {
            Status status = queue.poll();
            cur.next = status.node;
            cur = cur.next;
            if(status.node.next !=null) {
                queue.offer(new Status(status.node.next.val,status.node.next));
            }
        }
        return prefix.next;
    }

}
