package com.xjf.leetcode.string;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 8/26/21 2:09 PM
 */
class RevertString {


    /**
     * 反转字符串
     * 空间复杂度O(1)
     * 时间复杂度O(n)
     *
     * @param s
     */
    private void revertString(char[] s) {
        int length = s.length;
        for(int left=0,right =length-1;left>=right;left++,right--) {
            char temp  = s[right];
            s[right] = s[left];
            s[left] = temp;
        }
    }
}
