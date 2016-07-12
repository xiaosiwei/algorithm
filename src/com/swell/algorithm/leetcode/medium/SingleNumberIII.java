package com.swell.algorithm.leetcode.medium;

/**
 * Created by xiaosiwei on 16/7/12.
 * Refer to : https://leetcode.com/problems/single-number-iii/
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int andOrResult = 0;
        for (int i = 0;i < nums.length;i++) andOrResult ^= nums[i];


        int[] result = new int[]{0,0};
        int filter = findFilter(andOrResult);
        for (int i = 0;i < nums.length;i++) {
            if ( (nums[i] & filter) == 0) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }

        return result;
    }

    private int findFilter(int req) {
        int result = 1;
        while(true) {
            if ( (result & req) != 0)  {
                return result;
            } else {
                result <<= 1;
            }
        }
    }
}
