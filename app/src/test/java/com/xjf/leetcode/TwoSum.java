package com.xjf.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 6/8/21 3:13 PM
 */
public class TwoSum {


    /**
     * https://leetcode-cn.com/problems/two-sum/
     */
    @Test
    public void main() {
       int[] numbers = {2,7,11,15};
        try {
            int[] result = twoSum2(numbers,9);
            System.out.println(Arrays.toString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 暴力解法
     * 时间复杂度: O(n2)
     * 空间复杂度：O(1)
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) throws Exception {
        for(int i = 0;i<numbers.length;i++) {
            for(int j = i+1;j<numbers.length;j++) {
                if(numbers[j] == target - numbers[i]) {
                    return new int[]{i,j};
                }
            }
        }
        throw new Exception("找不到匹配的");
    }


    /**
     * HashMap
     * 时间复杂度(O(n))
     * 空间复杂度(O(n))
     * @param nums
     * @param target
     * @return
     * @throws Exception
     */
    public int[] twoSum2(int[] nums, int target) throws Exception{
        Map temple = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
            int another = target - nums[i];
            if(temple.containsKey(another)) {
                return new int[]{(int) temple.get(another),i};
            }
            temple.put(nums[i],i);
        }
        throw new Exception("找不到匹配的");
    }

}
