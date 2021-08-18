package com.xjf.leetcode.array;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 8/16/21 2:27 PM
 */
class RemoveVFromArray {


    /**
     * 暴力解决法
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     * @param nums
     * @param value
     */
    private int removeVFromArray(int[] nums,int value) {
        int size = nums.length;
        for(int i=0;i<size;i++) {
            if(nums[i] == value) {
                for(int j=i;j<size;j++) {
                    nums[j] = nums[j+1];
                    i--;
                    size--;
                }
            }
        }
        return size;
    }


    /**
     * 双指针法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @param value
     * @return
     */
    private int removeVFromArrayByPointer(int[] nums,int value) {
        int slowIndex = 0;
        for(int fastIndex = 0;fastIndex<nums.length;fastIndex++) {
            if(nums[fastIndex] != value) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return  slowIndex;
    }





}
