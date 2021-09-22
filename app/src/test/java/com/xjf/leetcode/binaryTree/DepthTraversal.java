package com.xjf.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthTraversal {

    /**
     * 深度遍历
     * @param root
     * @return
     */
    public List<Integer> dts(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode top = stack.pop();
            result.add(top.val);
            if (top.right !=null) stack.push(top.right);
            if(top.left !=null) stack.push(top.left);
        }
        return result;
    }
}
