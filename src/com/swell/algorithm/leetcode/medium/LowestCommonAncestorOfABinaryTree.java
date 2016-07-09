package com.swell.algorithm.leetcode.medium;

import java.util.LinkedList;

/**
 * Created by xiaosiwei on 16/7/9.
 * Refer to : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Common link node
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) return p;
        if (root == null || p == null || q == null) return null;

        LinkedList<TreeNode> pList = new LinkedList();
        LinkedList<TreeNode> qList = new LinkedList();

        findList(root, p, pList);
        findList(root, q, qList);

        return commonNode(pList, qList);
    }

    private TreeNode commonNode(LinkedList<TreeNode> pList, LinkedList<TreeNode> qList) {
        TreeNode preP =  pList.pollLast();
        TreeNode preQ =  qList.pollLast();

        TreeNode p = pList.pollLast();
        TreeNode q = qList.pollLast();

        while (p == q) {
            preP = p;
            preQ = q;

            p = pList.pollLast();
            q = qList.pollLast();
        }

        return preP;
    }

    private boolean findList(TreeNode root, TreeNode p, LinkedList pList) {
        if (root == null) return false;

        if (root == p) {
            pList.addLast(root);
            return true;
        }

        if (root.left != null && findList(root.left, p, pList) ||
                root.right != null && findList(root.right, p , pList)) {
            pList.addLast(root);
            return true;
        }

        return false;
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
