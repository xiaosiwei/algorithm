package com.swell.algorithm.leetcode.medium;

/**
 * Created by xiaosiwei on 16/7/9.
 * Refer to : https://leetcode.com/problems/single-number/
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1;i <nums.length;i++) {
            result ^= nums[i];
        }
        return result;
    }
}
