package com.xjf.leetcode.string;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 8/28/21 11:50 AM
 */
class GetLongestPalindrome {


    /**
     * 获取字符串最长回文
     * 中心扩展法
     * @param s
     * @return
     */
    private String getLongestPalindrome(String s) {
        if(s ==null || s.equals("")) {
            return s;
        }
        int start = 0,end = 0;
        for(int i=0;i<s.length();i++) {
            int length1 = expandAroundCenter(s,i,i);
            int length2 = expandAroundCenter(s,i,i+1);
            int maxLength = Math.max(length1,length2);
            if(maxLength > end -start+1 ) {
                start = i - (maxLength-1)/2;
                end = i + maxLength/2;
            }

        }
        return s.substring(start,end+1);
    }


    /**
     * 中心向外扩展
     * @param s
     * @param i
     * @param j
     * @return
     */
    private int expandAroundCenter(String s,int i,int j) {
        while(i>=0 && j<s.length()&& s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j-i-1;
    }


}
