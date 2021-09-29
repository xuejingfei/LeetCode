package com.xjf.leetcode.array;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 8/26/21 2:33 PM
 */
class FindRepeatNum {

    /**
     * 找到数组中重复项
     * @param nums
     * @return
     */
    int findRepeatNum(int[] nums) {
       for(int i = 0; i <nums.length ; i++){
           if(nums[i] == i) {
               continue;
           }
           if(nums[nums[i]] == nums[i]) {
               return nums[i];
           }

           int tmp = nums[i];
           nums[i] = nums[tmp];
           nums[tmp] = tmp;

       }
       return 0;
    }

}
