package com.swell.algorithm.leetcode.medium;

/**
 * Created by xiaosiwei on 16/7/9.
 * Refer to : https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length <= 0) return 0;
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0];


        for (int i = 1;i < nums.length;i++) {
            int t1 = max[i-1] * nums[i];
            int t2 = min[i-1] * nums[i];

            max[i] = Math.max(nums[i], Math.max(t1,t2));
            min[i] = Math.min(nums[i], Math.min(t1,t2));
        }

        int result = max[0];
        for (int i = 1;i < max.length;i++) {
            result = Math.max(result, max[i]);
        }

        return result;
    }
}
