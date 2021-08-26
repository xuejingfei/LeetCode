package com.xjf.leetcode.linkedList;

import org.junit.Test;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 6/8/21 4:12 PM
 */
public class ListNodeSum {


    /**
     * https://leetcode-cn.com/problems/add-two-numbers/
     */
    @Test
    public void main() {
        addTwoNumbers(new ListNode(1),new ListNode(2));
    }


    /**
     * 时间复杂度（O(max(node1,node2)）
     * 空间复杂度0（1）
     * @param node1
     * @param node2
     * @return
     */
    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (node1 != null || node2 != null) {
            int value1 = node1 != null ? node1.value : 0;
            int value2 = node2 != null ? node2.value : 0;
            int sum = value1 + value2 + carry;
            ListNode node  = new ListNode(sum % 10);
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            carry = sum / 10;
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

}
