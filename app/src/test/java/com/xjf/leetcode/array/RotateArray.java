package com.xjf.leetcode.array;

/**
 * Description:
 * Author: xuejingfei
 * E-mail: xue.jingfei@immomo.com
 * Date: 9/27/21 11:56 AM
 */
class RotateArray {


    /**
     * 旋转数组
     * @param array
     * @param k
     */
    private void rotateArray(int[] array,int k) {
        int length = array.length;
        int kth = k % length;
        revertArray(array,0,length-1);
        revertArray(array,0,kth-1);
        revertArray(array,kth,length-1);
    }

    private void revertArray(int[] array,int start,int end) {
        while(start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end -- ;
        }
    }

}
