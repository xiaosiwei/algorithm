package com.swell.algorithm.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaosiwei on 16/7/22.
 * Refer to : https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if (n == 0) return false;
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        while (n != 1) {
            int value = getValue(n);
            if (set.contains(value)) {
                return false;
            } else {
                set.add(value);
            }
            n = value;
        }
        return true;
    }

    private int getValue(int req) {
        int result = 0;
        while (req != 0) {
            int tmp = req % 10;
            result += tmp * tmp;
            req = req / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(2));
    }
}
