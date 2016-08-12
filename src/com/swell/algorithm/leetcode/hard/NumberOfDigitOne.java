package com.swell.algorithm.leetcode.hard;

/**
 * Created by xiaosiwei on 16/8/12.
 */
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        if (n < 10) return 1;
        int weight = getWeight(n);
        int top = topOne(n);
        if (top == 1) {
            return  ( n - weight + 1 ) + countDigitOne(n-weight) + countDigitOne(weight-1);
        } else {
            return (top-2)*countDigitOne(weight-1) + countDigitOne(n - top * weight) + countDigitOne(weight*2-1);
        }
    }

    private int getWeight(int n) {
        int result = 1;
        while (n >= 10) {
            n /= 10;
            result *= 10;
        }
        return result;
    }

    private int topOne(int n) {
        while(n >= 10) {
            n = n / 10;
        }
        return n;
    }

    public static void main(String[] args) {
        NumberOfDigitOne numberOfDigitOne = new NumberOfDigitOne();
        System.out.println(numberOfDigitOne.countDigitOne(1410065408));
    }
}
