package com.xjf.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/10/5 22:38
 */
class GenerateParenthesis {


    /**
     * 生成有效括号
     * @param n
     */
    private List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrance(ans,new StringBuilder(),0,0,n);
        return ans;
    }


    private void backTrance(List<String> ans,StringBuilder cur,int open,int close,int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if(open < max) {
            backTrance(ans,cur.append("("),open+1,close,max);
            cur.deleteCharAt(cur.length()-1);
        }
        if(close <open) {
            backTrance(ans,cur.append(")"),open,close+1,max);
            cur.deleteCharAt(cur.length()-1);
        }
    }

}
