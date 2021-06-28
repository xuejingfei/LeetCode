package com.xjf.leetcode.NTree;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/6/23 22:36
 */
class NTreeOrder {

    //<editor-fold des = "N叉树的层序遍历">

    /**
     * 迭代法
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderN(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if(root == null) return result;
        queue.add(root);
        List<Integer> temp;
        while(!queue.isEmpty()) {
            int size = queue.size();
            temp = new ArrayList<>();
            for(int i=0;i<size;i++) {
                Node tNode = queue.pop();
                temp.add(tNode.val);
                if(tNode.children !=null) queue.addAll(tNode.children);
            }
            result.add(temp);
        }
        return result;
    }


    /**
     * 递归法
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderRecursive(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root !=null) traverseNode(result,root,0);
        return result;
    }


    private void traverseNode(List<List<Integer>> result,Node node,int level) {
        if(result.size() <=level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for(Node child:node.children) {
            traverseNode(result,child,level+1);
        }
    }


    //</editor-fold>

    //<editor-fold des="N叉树的前序深度遍历">

    /**
     * 递归
     * @param root
     * @return
     */
    private List<Integer> depthBeforeNByRecursive(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        depthBeforeByRecursive(root,result);
        return result;
    }

    private void depthBeforeByRecursive(Node root,List<Integer> result) {
        if(root == null) return;
        result.add(root.val);
        if(root.children !=null) {
            for(Node node:root.children) {
                depthBeforeByRecursive(node,result);
            }
        }
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    private List<Integer> depthBeforeNByIteration(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<Node> stack =new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node pNode = stack.pop();
            if(pNode !=null) result.add(pNode.val);
            if(pNode.children != null) {
                for(int i= pNode.children.size()-1;i>=0; i--) {
                    stack.push(pNode.children.get(i));
                }
            }
        }
        return result;
    }


    /**
     * 标记法
     * @param root
     * @return
     */
    private List<Integer> depthBeforeNByTag(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<Node> stack =new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node pNode = stack.pop();
            if(pNode !=null) {
                if(pNode.children !=null) {
                    for(int i= pNode.children.size()-1;i>=0; i--) {
                        stack.push(pNode.children.get(i));
                    }
                }
                stack.push(pNode);
                stack.push(null);
            } else {
                Node node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }



    //</editor-fold>

    //<editor-fold des="N叉树的后序深度遍历">

    /**
     * 递归法
     * @param root
     * @return
     */
    private List<Integer> depthAfterNByRecursive(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        depthAfterByRecursive(root,result);
        return result;
    }

    private void depthAfterByRecursive(Node root,List<Integer> result) {
        if(root == null) return;
        if(root.children !=null) {
            for(Node node:root.children) {
                depthAfterByRecursive(node,result);
            }
        }
        result.add(root.val);
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    private List<Integer> depthAfterNByIteration(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<Node> stack =new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node pNode = stack.pop();
            if(pNode !=null) result.add(pNode.val);
            if(pNode.children != null) {
                for(Node node:pNode.children) {
                    stack.push(node);
                }
            }
        }
        Collections.reverse(result);
        return result;
    }


    /**
     *
     * @param root
     * @return
     */
    private List<Integer> depthAfterNByTag(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<Node> stack =new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node pNode = stack.pop();
            if(pNode !=null) {
                stack.push(pNode);
                stack.push(null);
                if(pNode.children !=null) {
                    for(int i= pNode.children.size()-1;i>=0; i--) {
                        stack.push(pNode.children.get(i));
                    }
                }
            } else {
                Node node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
    //</editor-fold>


}
