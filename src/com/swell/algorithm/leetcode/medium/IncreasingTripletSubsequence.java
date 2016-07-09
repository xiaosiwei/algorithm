package com.swell.algorithm.leetcode.medium;

/**
 * Created by xiaosiwei on 16/7/9.
 * Refer to : https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int a = nums[0];
        int b = 0;
        boolean flag = false;

        for (int i = 1;i < nums.length;i++) {
            if (nums[i] > a) {
                if (!flag) {
                    flag = true;
                    b = nums[i];
                } else {
                    if (nums[i] > b) {
                        return true;
                    } else {
                        b = nums[i];
                    }
                }
            } else {
                a = nums[i];
            }
        }

        return false;
    }
}
