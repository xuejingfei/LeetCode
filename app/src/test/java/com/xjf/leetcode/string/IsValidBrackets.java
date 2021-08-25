package com.xjf.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 8/11/21 10:46 AM
 */
class IsValidBrackets {

    private Map<Character, Character> maps = new HashMap();

    public IsValidBrackets() {
        maps.put(')', '(');
        maps.put('}', '{');
        maps.put(']', '[');
    }


    /**
     * 判断是否是有效括号
     *
     * @param target
     * @return
     */
    public boolean isValidBrackets(String target) {
        if (target == null || target.length() == 1) return false;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < target.length(); i++) {
            char a = target.charAt(i);
            if (maps.containsKey(a)) {
                Character top = stack.isEmpty() ? '#' : stack.pop();
                if (top != maps.get(a)) return false;
            } else {
                stack.push(a);
            }
        }
        return stack.isEmpty();
    }

}
