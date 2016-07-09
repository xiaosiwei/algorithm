package com.swell.algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * Created by xiaosiwei on 16/7/9.
 * Refer to : https://leetcode.com/problems/h-index/
 */
public class H_Index {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0;i < citations.length;i++) {
            if (citations[i] >= (citations.length - i)) {
                return citations.length - i;
            }
        }
        return 0;
    }
}
