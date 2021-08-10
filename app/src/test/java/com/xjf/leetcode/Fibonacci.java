package com.xjf.leetcode;

/**
 * Description:斐波那契数列
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 8/7/21 1:04 PM
 */
class Fibonacci {

    /**
     * 递归做法
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(n)
     *
     * @param n
     * @return
     */
    public int fnByRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fnByRecursive(n - 2) + fnByRecursive(n - 1);
    }


    /**
     * 动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public int fnByDynamic(int n) {
        if (n == 0 || n == 1) return n;
        int first = 0;
        int second = 1;
        int third = 1;
        for (int i = 2; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }


}
