package com.xjf.leetcode.array;

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2021/10/6 00:08
 */
class SearchRotate {


    private int search(int[] nums,int target) {
        int lo = 0;
        int hi = nums.length-1;
        while (lo<=hi) {
            int middle = lo + (hi-lo)/2;
            if (nums[middle] == target) return middle;
            if (nums[middle] >nums[lo]) {
                if (target >= nums[lo] && target<nums[middle]) {
                    hi = middle -1;
                } else {
                    lo = middle +1;
                }
            } else {
                if (target > nums[middle] && target < nums[hi]) {
                    lo = middle + 1;
                } else {
                    hi = middle -1;
                }
            }
        }
        return -1;
    }
}
