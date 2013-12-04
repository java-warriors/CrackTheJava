package com.javawarriors.leetcode;
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