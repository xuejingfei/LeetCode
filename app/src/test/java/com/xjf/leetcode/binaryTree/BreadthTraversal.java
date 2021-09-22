package com.xjf.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthTraversal {

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    private List<List<Integer>> bts(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> temp;
        while (!queue.isEmpty()) {
            temp = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left !=null) queue.offer(node.left);
                if(node.right !=null) queue.offer(node.right);
            }
            result.add(temp);
        }
        return result;
    }
}
