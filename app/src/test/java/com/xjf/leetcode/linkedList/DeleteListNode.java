package com.xjf.leetcode.linkedList;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/9/17 15:41
 */
class DeleteListNode {

    private void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
