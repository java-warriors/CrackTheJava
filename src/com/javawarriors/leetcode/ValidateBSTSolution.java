package com.javawarriors.leetcode;

public class ValidateBSTSolution {
    static Integer prevInorderTraversalValue = null;
    private boolean inOrderTraversal(TreeNode root){
        if(root == null){
            return true;
        }
        boolean left = inOrderTraversal(root.left);
        if(prevInorderTraversalValue == null){
            prevInorderTraversalValue = root.val - 1;
        }
        if(prevInorderTraversalValue >= root.val){
            return false;
        } else{
            prevInorderTraversalValue = root.val;
        }
        boolean right = inOrderTraversal(root.right);
        return left&&right;
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        prevInorderTraversalValue = null;
        return inOrderTraversal(root);
    }
}
