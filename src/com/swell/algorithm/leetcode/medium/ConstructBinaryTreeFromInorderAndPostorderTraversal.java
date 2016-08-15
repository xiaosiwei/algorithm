package com.swell.algorithm.leetcode.medium;

/**
 * Created by xiaosiwei on 16/8/12.
 * Refer to : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int poststart) {
        if (inEnd < inStart) return null;
        TreeNode root = new TreeNode(postorder[poststart]);
        if (inEnd == inStart) return root;

        for (int i = inStart;i <= inEnd;i++) {
            if (inorder[i] == root.val) {
                root.left = buildTree(inorder, inStart, i-1, postorder, poststart-i);
                root.right = buildTree(inorder, i+1, inEnd, postorder, poststart-1);
            }
        }

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] in = {2,1};
        int[] po = {2,1};
        ConstructBinaryTreeFromInorderAndPostorderTraversal traversal = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        System.out.println(traversal.buildTree(in, po));
    }
}
