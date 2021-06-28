package com.xjf.leetcode.binaryTree;

import java.util.LinkedList;

/**
 * Author：xuejingfei
 *
 * Description： 反转二叉树
 *
 * Date：2021/6/27 22:19
 */
class ReversalBinaryTree {

    /**
     * 使用前序递归
     * @param root
     * @return
     */
    private TreeNode reversalByBeforeRecursive(TreeNode root) {
        if(root == null) return root;
        swapLeftRight(root);
        reversalByBeforeRecursive(root.left);
        reversalByBeforeRecursive(root.right);
        return root;
    }

    /**
     * 使用后序递归
     * @param root
     * @return
     */
    private TreeNode reversalByAfterRecursive(TreeNode root) {
        if(root == null) return root;
        reversalByBeforeRecursive(root.left);
        reversalByBeforeRecursive(root.right);
        swapLeftRight(root);
        return root;
    }


    /**
     * 使用递归
     * @param root
     * @return
     */
    private TreeNode reversalByIteration(TreeNode root) {
        if(root ==null) return root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode tNode = stack.pop();
            swapLeftRight(tNode);
            if(tNode.right !=null) stack.push(tNode.right);
            if(tNode.left!=null) stack.push(tNode.left);
        }
        return root;
    }


    private TreeNode reversalByIteration2(TreeNode root) {
        if(root == null) return root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode tNode = stack.pop();
            if(tNode !=null) {
                if(tNode.right!=null) stack.push(tNode.right); //右
                if(tNode.left!=null) stack.push(tNode.left);//左
                stack.push(tNode); //中
                stack.push(null);
            } else {
                TreeNode node = stack.pop();
                swapLeftRight(node);
            }
        }

        return root;
    }




    /**
     * 层次遍历
     * @param root
     * @return
     */
    private TreeNode reversalByDepth(TreeNode root) {
        if(root ==null) return root;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode tNode = queue.poll();
            swapLeftRight(tNode);
            if(tNode.right !=null) queue.add(tNode.right);
            if(tNode.left!=null) queue.add(tNode.left);
        }
        return root;
    }

    private void swapLeftRight(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }







}
