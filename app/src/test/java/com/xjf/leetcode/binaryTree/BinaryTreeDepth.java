package com.xjf.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/6/12 14:31
 */
class BinaryTreeDepth {




    //<editor-fold des = "获取二叉树的深度">
    /**
     * 获取二叉树的深度
     * 标记法
     * @param root
     * @return
     */
    public int maxDepthByTag(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int result = 0;
        while (!queue.isEmpty()) {
            TreeNode pNode = queue.poll();
            if (pNode != null) {
                if (pNode.left != null) queue.offer(pNode.left);
                if (pNode.right != null) queue.offer(pNode.right);
                if(queue.size()>1 && queue.peek() == null) {
                    queue.offer(null);
                }
            } else {
                result++;
            }
        }
        return result;
    }


    /**
     * 使用临时队列
     * @param root
     * @return
     */
    public int maxDepthByLever(TreeNode root) {
        if (root ==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<TreeNode> temp;
        int res = 0;
        while (!queue.isEmpty()) {
            temp = new LinkedList<>();
            for (TreeNode node:queue) {
                if (node.left !=null) temp.add(node.left);
                if (node.right !=null) temp.add(node.right);
            }
            queue = temp;
            res ++;
        }
        return res;
    }



    /**
     * 后序递归做法
     * @param root
     * @return
     */
    public int maxDepthRecursive(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepthRecursive(root.left),maxDepthRecursive(root.right)) +1;

    }


    //</editor-fold>


    //<editor-fold des = "二叉树广度遍历">


    /**
     * 层次遍历
     * 使用
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        LinkedList<TreeNode> temp;
        List<Integer> list;
        while(!stack.isEmpty()) {
            list = new LinkedList<>();
            temp = new LinkedList<>();
            for(TreeNode node:stack) {
                list.add(node.val);
                if(node.left!=null)temp.add(node.left);
                if(node.right!=null) temp.add(node.right);
            }
            stack = temp;
            result.add(list);
        }
        return result;
    }


    /**
     * 根据层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        List<Integer> list;
        while(!queue.isEmpty()) {
            list = new LinkedList<>();
            int queueSize = queue.size();
            for(int i=0;i<queueSize;i++){
                TreeNode pNode = queue.poll();
                list.add(pNode.val);
                if(pNode.left !=null) queue.add(pNode.left);
                if(pNode.right !=null) queue.add(pNode.right);
            }
            result.add(list);
        }

        return result;


    }

    //</editor-fold>



    //<editor-fold des = "二叉树广度之字型遍历">




    public List<List<Integer>> levelOrderZ(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        LinkedList<TreeNode> temp;
        List<Integer> list;
        boolean isReverse = false;
        while(!stack.isEmpty()) {
            list = new LinkedList<>();
            temp = new LinkedList<>();
            for(TreeNode node:stack) {
                list.add(node.val);
                if(node.left!=null)temp.add(node.left);
                if(node.right!=null) temp.add(node.right);
            }
            stack = temp;
            if(isReverse) Collections.reverse(list);
            result.add(list);
            isReverse = !isReverse;
        }

        return result;
    }



    public List<List<Integer>> levelOrderZ2(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> temp;
        queue.add(root);
        while(!queue.isEmpty()) {
            temp = new LinkedList<>();
            int queueSize = queue.size();
            for(int i=0;i<queueSize;i++) {
                TreeNode pNode = queue.poll();
                if(result.size()%2 ==0) temp.addLast(pNode.val); else temp.addFirst(pNode.val);
                if(pNode.left!=null)queue.add(pNode.left);
                if(pNode.right!=null) queue.add(pNode.right);
            }
            result.add(temp);
        }
        return result;

    }




    //</editor-fold>



    //<editor-fold des = "二叉树广度自低向上遍历">
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<TreeNode> temp;
        List<Integer> list;
        while(!queue.isEmpty()) {
            list = new LinkedList<>();
            temp = new LinkedList<>();
            for(TreeNode node:queue) {
                list.add(node.val);
                if(node.left!=null)temp.add(node.left);
                if(node.right!=null) temp.add(node.right);
            }
            queue = temp;
            result.addFirst(list);
        }

        return result;
    }


    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> temp;
        while(!queue.isEmpty()) {
            temp = new LinkedList<>();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode top = queue.poll();
                temp.add(top.val);
                if(top.left !=null) queue.add(top.left);
                if(top.right !=null) queue.add(top.right);
            }
            result.addFirst(temp);
        }
        return result;
    }



    //</editor-fold>


    //<editor-fold des = "二叉树广度右视图遍历">


    /**
     * 广度遍历
     * @param root
     * @return
     */
    public List<Integer> levelOrderRight(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode pNode = queue.poll();
                if(i == size-1) result.add(pNode.val);
                if(pNode.left !=null) queue.add(pNode.left);
                if(pNode.right !=null) queue.add(pNode.right);
            }
        }
        return result;

    }




    //</editor-fold>


    /**
     * 广度遍历
     * @param root
     * @return
     */
    public List<Double> levelOrderAverage(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        double sum = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i =0;i<size;i++) {
                TreeNode pNode = queue.poll();
                sum += pNode.val;
                if(pNode.left !=null) queue.add(pNode.left);
                if(pNode.right!=null) queue.add(pNode.right);
            }
            result.add(sum/size);
            sum = 0;
        }
        return result;
    }


    /**
     * 深度遍历
     * @param root
     * @return
     */
    public List<Double> depthOrderAverage(TreeNode root){
        List<Integer> counts = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        dfs(root, 0, counts, sums);
        List<Double> averages = new ArrayList<>();
        int size = sums.size();
        for (int i = 0; i < size; i++) {
            averages.add(sums.get(i) / counts.get(i));
        }

        return averages;
    }


    public void dfs(TreeNode root,int level,List<Integer> counts,List<Double> sums) {
        if(root == null) return;
        if(level < sums.size()) {
            sums.set(level,sums.get(level)+root.val);
            counts.set(level,counts.get(level) + 1);
        }else {
            sums.add((double) root.val);
            counts.add(1);
        }

        dfs(root.left,level+1,counts,sums);
        dfs(root.right,level+1,counts,sums);
    }





}
