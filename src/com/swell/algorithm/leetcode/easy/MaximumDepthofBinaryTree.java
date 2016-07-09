package com.swell.algorithm.leetcode.easy;

/**
 * Created by xiaosiwei on 16/7/9.
 * Refer to : https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {

        if (null == root) return 0;
        int leftLength = 0;
        int rightLength = 0;
        if (null != root.left) {
            leftLength = maxDepth(root.left);
        }
        if (null != root.right) {
            rightLength = maxDepth(root.right);
        }
        return (leftLength > rightLength ? leftLength : rightLength) + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
