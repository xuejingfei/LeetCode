package com.xjf.leetcode.NTree;

import java.util.List;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/6/23 22:34
 */
class Node {
    public int val;
    public List<Node> children;

    public Node(int _val){
        val = _val;
    }

    public Node(int _val,List<Node> _children){
        children = _children;
    }
}
