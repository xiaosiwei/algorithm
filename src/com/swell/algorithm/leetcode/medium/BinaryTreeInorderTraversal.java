package com.swell.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaosiwei on 16/7/9.
 * Refer to : https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);

        return result;
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
