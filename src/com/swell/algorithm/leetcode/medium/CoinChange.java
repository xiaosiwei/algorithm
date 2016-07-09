package com.swell.algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * Created by xiaosiwei on 16/7/9.
 * Refer to : https://leetcode.com/problems/coin-change/
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        for (int i = 0;i <= amount;i++) {
            dp[i] = -1;
        }

        dp[0] = 0;

        for (int i = coins.length-1;i >= 0;i--) {
            for (int j=0;j <= amount;j++) {
                if (dp[j] >= 0) {
                    for (int k = 1; j+k*coins[i] <= amount;k++) {
                        int cur = j+k*coins[i];
                        dp[cur] = dp[cur] == -1 ? (dp[j] + k) : Math.min(dp[cur], dp[j]+k);
                        if (cur == amount) {
                            return dp[cur];
                        }
                    }
                }
            }
        }

        return dp[amount];
    }
}
