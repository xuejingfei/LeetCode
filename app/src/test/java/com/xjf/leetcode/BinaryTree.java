package com.xjf.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 6/9/21 11:19 AM
 */
class BinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 前序深度遍历（递归法）
     *
     * @param rootNode
     */
    public void depthBeforeOrder(TreeNode rootNode, List<Integer> list) {
        if (rootNode == null) {
            return;
        }
        list.add(rootNode.val);
        depthBeforeOrder(rootNode.left, list);
        depthBeforeOrder(rootNode.right, list);
    }


    /**
     * 中序深度遍历（递归法）
     *
     * @param rootNode
     * @param list
     */
    public void depthMiddleOrder(TreeNode rootNode, List<Integer> list) {
        if (rootNode == null) {
            return;
        }
        depthMiddleOrder(rootNode.left, list);
        list.add(rootNode.val);
        depthMiddleOrder(rootNode.right, list);
    }


    /**
     * 后序深度排列（递归法）
     *
     * @param rootNode
     * @param list
     */
    public void depthAfterOrder(TreeNode rootNode, List<Integer> list) {
        if (rootNode == null) {
            return;
        }
        depthAfterOrder(rootNode.left, list);
        depthAfterOrder(rootNode.right, list);
        list.add(rootNode.val);
    }


    /**
     * 前序深度排列
     * 访问节点
     * 处理节点
     *
     * @param rootNode
     * @param list
     */
    public void depthBeforeOrderIteration(TreeNode rootNode, List<Integer> list) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = rootNode;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                list.add(pNode.val);
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode node = stack.pop();
                pNode = node.right;
            }
        }
    }

    /**
     * 中序深度排列
     *
     * @param rootNode
     * @param list
     */
    public void depthMiddleOrderIteration(TreeNode rootNode, List<Integer> list) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = rootNode;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode node = stack.pop();
                list.add(node.val);
                pNode = node.right;
            }
        }
    }


    /**
     * 后序深度排列
     *
     * @param rootNode
     * @param list
     */
    public void depthAfterOrderIteration(TreeNode rootNode, List<Integer> list) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (rootNode != null) stack.push(rootNode);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            stack.poll();
            if (node != null) {
                stack.offer(node); //中
                stack.offer(null);
                if (node.right != null) stack.offer(node.right); //右
                if (node.left != null) stack.offer(node.left);// 左

            } else {
                TreeNode top = stack.pop();
                list.add(top.val);
            }
        }
    }


    /**
     * 深度排列
     *
     * @param rootNode
     * @param list
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
     *
     * @param root
     */
    public List<List<Integer>> breadthOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

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
                if(!queue.isEmpty() && queue.peek() == null) {
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


    /**
     * 获取二叉树的深度
     *
     * @param rootNode
     * @return
     */
    public int getBinaryDepth(TreeNode rootNode) {
        if (rootNode == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);
        queue.offer(null);
        int result = 0;
        while (!queue.isEmpty()) {
            TreeNode pNode = queue.poll();
            if (pNode != null) {
                if (pNode.left != null) queue.offer(pNode.left);
                if (pNode.right != null) queue.offer(pNode.right);
                if(queue.isEmpty() || queue.peek() == null) {
                    queue.offer(null);
                }
            } else {
                queue.poll();
                result++;
            }
        }
        return result;
    }


}
