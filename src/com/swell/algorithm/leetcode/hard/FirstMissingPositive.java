package com.swell.algorithm.leetcode.hard;

/**
 * Created by xiaosiwei on 16/8/26.
 * Refer to : https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int tmp;
        for (int i = 0;i < length;i++) {
            if (nums[i] > nums.length || nums[i] <= 0) continue;
            if (nums[i] != (i+1) && nums[nums[i]-1] != nums[i]) {
                tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
                i--;
            }
        }
        for (int i = 0;i < length;i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }

        return length+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(nums));
    }
}
