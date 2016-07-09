package com.swell.algorithm.leetcode.medium;

/**
 * Created by xiaosiwei on 16/7/9.
 * Refer to : https://leetcode.com/problems/integer-break/
 * Actually by mod 3
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n <= 3) {
            return  n - 1;
        }

        int result = 1;


        while (n >= 5) {
            result *= 3;
            n -= 3;
        }

        result *= n;

        return result;
    }
}
