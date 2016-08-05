package com.swell.algorithm.leetcode.hard;

/**
 * Created by xiaosiwei on 16/8/5.
 * Refer to: https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        dp[0][0] = 0;
        for (int i = 1;i <= word1.length();i++) dp[i][0] = i;
        for (int j = 1;j <= word2.length();j++) dp[0][j] = j;
        for (int i = 1;i <= word1.length();i++) {
            for (int j = 1;j<= word2.length();j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0;i < word1.length();i++) {
            for (int j = 0;j < word2.length();j++) {
                int x = i+1;
                int y = j+1;
                dp[x][y] = Math.min(dp[x][y], dp[x-1][y]+1);
                dp[x][y] = Math.min(dp[x][y], dp[x][y-1]+1);
                dp[x][y] = Math.min(dp[x][y], dp[x-1][y-1]+1);
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[x][y] = Math.min(dp[x][y], dp[x-1][y-1]);
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance("a","b"));
    }
}
