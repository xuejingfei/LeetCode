package com.xjf.leetcode.num;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/9/7 21:30
 */
class IsPalindrome {

    boolean isPalindrome(int x) {
        if(x<0 || (x%10 == 0 && x !=0)) {
            return false;
        }
        int rev = 0;
        while(x > rev) {
            rev = rev*10 + x%10;
            x = x/10;
        }
        return x == rev || x == rev/10;
    }
}
