package com.swell.algorithm.leetcode.hard;

/**
 * Created by xiaosiwei on 16/8/4.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s2.length() + s1.length() != s3.length())   return false;

        boolean[][][] dp = new boolean[s3.length()+1][s1.length()+1][s2.length()+1];
        dp[0][0][0] = true;
        for (int i = 1;i <= s3.length();i++) {
            for (int j = 0;j <= i;j++) {
                int k = i - j;
                if (j <= s1.length() && k <= s2.length()) {
                    if (j > 0) {
                        dp[i][j][k] = dp[i][j][k] ||
                                (s3.charAt(i - 1) == s1.charAt(j - 1) && dp[i - 1][j - 1][k]);
                    }
                    if (k > 0) {
                        dp[i][j][k] = dp[i][j][k] ||
                                (s3.charAt(i - 1) == s2.charAt(k - 1) && dp[i - 1][j][k - 1]);
                    }
                }
            }
        }

        return dp[s3.length()][s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        InterleavingString interleavingString = new InterleavingString();
        System.out.println(interleavingString.isInterleave(s1,s2,s3));
    }
}
