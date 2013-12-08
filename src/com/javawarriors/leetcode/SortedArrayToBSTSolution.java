package com.javawarriors.leetcode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SortedArrayToBSTSolution {
    private TreeNode createBST(int[] num, int start, int end){
        if(start <= end){
            int mid = (start + end)/2;
            TreeNode root = new TreeNode(num[mid]);
            root.left = createBST(num, start, mid - 1);
            root.right = createBST(num, mid + 1, end);
            return root;
        }
        return null;
    }
	public TreeNode sortedArrayToBST(int[] num) {
        int start = 0;
        int end = num.length - 1;
        return createBST(num, start, end);
    }
}