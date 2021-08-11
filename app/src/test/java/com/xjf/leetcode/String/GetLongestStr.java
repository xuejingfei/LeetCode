package com.xjf.leetcode.String;

import org.junit.Test;

import java.util.HashSet;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 6/8/21 6:12 PM
 */
public class GetLongestStr {

    @Test
    public void main() {
        System.out.println(lengthOfLongestSubstring("abcdad"));
    }

    /**
     * 滑动窗口
     * 获取最长不重复子串
     *
     * @param target
     */
    public long lengthOfLongestSubstring(String target) {
        if (target == null) return 0;
        if (target.length() < 2) return target.length();
        int left = 0;
        int right = 0;
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        while (left < target.length() && right < target.length()) {
            if (!set.contains(target.charAt(right))) {
                set.add(target.charAt(right));
                result = Math.max(result, right - left + 1);
                right++;
            } else {
                set.remove(target.charAt(left));
                left++;
            }
        }
        return result;
    }


}
