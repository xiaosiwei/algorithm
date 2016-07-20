package com.swell.algorithm.leetcode.medium;

import java.util.Stack;

/**
 * Created by xiaosiwei on 16/7/20.
 * Refer to : https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        Stack stack = new Stack<String>();
        String[] strs = preorder.split(",");
        if (strs[0].equals("#")) {
            if (strs.length == 1) {
                return true;
            } else {
                return false;
            }
        }
        if (strs.length < 3)    return false;
        stack.push(strs[0]);
        int i = 1;
        while (i < strs.length) {
            if (strs[i].equals("#")) {
                while (stack.size() > 1 && stack.peek().equals("#")) {
                    stack.pop();
                    stack.pop();
                }
                if (stack.size() == 0) {
                    if (i == strs.length-1) {
                        return true;
                    } else {
                        return false;
                    }
                }
                stack.push("#");
            } else {
                if (stack.size() == 0)  return false;
                stack.push(strs[i]);
            }
            i++;
        }

        return stack.size() == 0 ? true : false;
    }

    public static void main(String[] args) {
        VerifyPreorderSerializationofaBinaryTree tr = new VerifyPreorderSerializationofaBinaryTree();
        System.out.println(tr.isValidSerialization("1,#,#,#,#"));
    }
}
