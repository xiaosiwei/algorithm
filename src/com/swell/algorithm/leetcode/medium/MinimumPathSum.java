package com.swell.algorithm.leetcode.medium;

/**
 * Created by xiaosiwei on 16/7/10.
 * Refer to : https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length <= 0) return 0;
        int[][] result = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            result[i][0] = i == 0 ? grid[i][0] : (result[i-1][0] + grid[i][0]);
        }

        for (int i = 0; i < grid[0].length; i++) {
            result[0][i] = i == 0 ? grid[0][i] : (result[0][i-1]+grid[0][i]);
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                result[i][j] = Math.min(result[i][j-1], result[i-1][j]) + grid[i][j];
            }
        }

        return result[result.length-1][result[0].length-1];
    }
}
