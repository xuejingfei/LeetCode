package com.xjf.leetcode.num;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/9/7 21:27
 */
class ReverseNum {

    /**
     * 反转整数
     * @param num
     * @return
     */
    private int reverse(int num) {
        int rev = 0;
        while(num !=0) {
            int temp = rev*10 + num%10;
            if(temp/10 !=rev) {
                return 0;
            }
            rev = temp;
            num = num / 10;
        }
        return rev;
    }


    private int reverse1(int num) {
        int rev = 0;
        while(num !=0) {
            if(rev > Integer.MAX_VALUE /10 || rev<Integer.MIN_VALUE /10) {
                return 0;
            }
            rev = rev*10 + num%10;
            num = num / 10;
        }
        return rev;
    }
}
