package com.xjf.leetcode.binaryTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: Author: xuejingfei E-mail: xue.jingfei@immomo.com Date: 6/9/21 11:19 AM
 */
public class BinaryTree {

    @Test
    public void test() {

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = right1;

    }

    //<editor-fold desc = "前序深度遍历">

    /**
     * 前序深度遍历（递归法）
     */
    public void beforeOrderByRecursive(TreeNode rootNode, List<Integer> list) {
        if (rootNode == null) {
            return;
        }
        list.add(rootNode.val);
        beforeOrderByRecursive(rootNode.left, list);
        beforeOrderByRecursive(rootNode.right, list);
    }


    /**
     * 前序深度遍历（迭代法）
     */
    public List<Integer> depthBeforeByIteration(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode head = stack.pop();
            if (head != null) result.add(head.val);
            if (head.right != null) stack.push(head.right);
            if (head.left != null) stack.push(head.left);

        }
        return result;
    }


    /**
     * 前序深度遍历（标记法）
     */
    public List<Integer> depthBeforeByTag(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top != null) {
                if (top.right != null) stack.push(top.right); //右
                if (top.left != null) stack.push(top.left); //左
                stack.push(top); //中
                stack.push(null);
            } else {
                TreeNode pNode = stack.pop();
                result.add(pNode.val);
            }
        }

        return result;

    }


    /**
     * 前序深度排列 访问节点 处理节点
     */
    public List<Integer> depthBeforeOrderIteration(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                result.add(pNode.val);
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode node = stack.pop();
                pNode = node.right;
            }
        }
        return result;
    }

    //</editor-fold>


    //<editor-fold desc = "中序深度遍历">

    /**
     * 中序深度遍历（递归法）
     */
    public void middleOrderByRecursive(TreeNode rootNode, List<Integer> list) {
        if (rootNode == null) {
            return;
        }
        middleOrderByRecursive(rootNode.left, list);
        list.add(rootNode.val);
        middleOrderByRecursive(rootNode.right, list);
    }


    /**
     * 中序深度排列
     */
    public List<Integer> middleOrderByIteration(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pNode = stack.pop();
            if (pNode != null) { //访问节点
                if (pNode.right != null) stack.push(pNode.right); //右
                stack.push(pNode);// 中
                stack.push(null);
                if (pNode.left != null) stack.push(pNode.left); //左
            } else { //处理节点
                TreeNode top = stack.pop();
                result.add(top.val);
            }
        }
        return result;
    }


    //</editor-fold>


    //<editor-fold desc = "后序深度遍历">


    /**
     * 递归法
     */
    public void afterOrderByRecursive(TreeNode root, List<Integer> result) {
        if (root == null) return;
        afterOrderByRecursive(root.left, result);
        afterOrderByRecursive(root.right, result);
        result.add(root.val);
    }


    /**
     * 迭代法
     */
    public List<Integer> afterOrderByIteration(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top != null) result.add(top.val);
            if (top.left != null) stack.push(top.left);
            if (top.right != null) stack.push(top.right);
        }
        Collections.reverse(result);
        return result;
    }


    /**
     * 标记法
     * @param root
     * @return
     */
    public List<Integer> afterOrderByTag(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top != null) {
                stack.push(top);
                stack.push(null);
                if (top.right != null) stack.push(top.right);
                if (top.left != null) stack.push(top.left);
            } else {
                TreeNode pNode = stack.pop();
                result.add(pNode.val);
            }
        }

        return result;
    }


    //</editor-fold>

    /**
     * 深度排列
     */
    public void depthOrder(TreeNode rootNode, List<Integer> list) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(rootNode);
        while (!stack.isEmpty()) {
            TreeNode pNode = stack.pop();
            list.add(pNode.val);
            if (pNode.right != null) {
                stack.add(pNode.right);
            }
            if (pNode.left != null) {
                stack.add(pNode.left);
            }
        }
    }


    /**
     * 广度优先遍历
     */
    public List<List<Integer>> breadthOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        queue.offer(null);

        while (!queue.isEmpty()) {
            TreeNode pNode = queue.poll();
            if (pNode != null) {
                list.add(pNode.val);
                if (pNode.left != null) queue.offer(pNode.left);
                if (pNode.right != null) queue.offer(pNode.right);
                if (!queue.isEmpty() && queue.peek() == null) {
                    queue.offer(null);
                }
            } else {
                queue.poll();
                list = new ArrayList<>();
                result.add(list);
            }
        }

        return result;
    }

}
