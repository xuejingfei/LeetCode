package com.xjf.leetcode.NTree;


import java.util.ArrayList;
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
     *
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




}
