package com.swell.algorithm.leetcode.medium;

/**
 * Created by xiaosiwei on 16/7/9.
 * Refer to : https://leetcode.com/problems/counting-bits/
 */
public class CountingBits {
    public int[] countBits(int num) {
        int array[] = new int[num+1];
        array[0] = 0;
        if (num < 1) {
            return array;
        }
        array[1] = 1;

        for (int i = 2;i <= num;i++) {
            if ((i&1) == 0) {
                array[i] = array[i/2];
            } else {
                array[i] = array[i/2]+1;
            }
        }

        return array;
    }
}
