package com.javawarriors.learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TreeQuestions {
	private static class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;
		}
	}

	private static class LCAHelper {
		Node lowestCommonAncestor;
	}

	public static Node lowestCommonAncestor(Node root, Node p, Node q) {
		if (root == null || p == null || q == null) {
			return root;
		}
		LCAHelper helper = new LCAHelper();
		postOrderTraversal(root, p, q, helper);
		return helper.lowestCommonAncestor;
	}

	private static boolean postOrderTraversal(Node root, Node p, Node q,
			LCAHelper helper) {
		if (root == null) {
			return false;
		}
		boolean left = postOrderTraversal(root.left, p, q, helper);
		boolean right = postOrderTraversal(root.right, p, q, helper);
		if ((left && right) || ((root == p || root == q) && (left || right))) {
			helper.lowestCommonAncestor = root;
		}
		return left || right || (root == p || root == q);
	}

	private static class BSTHelper {
		private Integer prevInorder;

		public Integer getPrevInorder() {
			return prevInorder;
		}

		public void setPrevInorder(Integer prevInorder) {
			this.prevInorder = prevInorder;
		}

		public boolean isBST() {
			return isBST;
		}

		public void setBST(boolean isBST) {
			this.isBST = isBST;
		}

		private boolean isBST;
	}

	public static boolean isBST(Node n) {
		if (n == null) {
			return false;
		}
		BSTHelper helper = new BSTHelper();
		helper.setBST(true);
		helper.setPrevInorder(null);
		helper = inorder_traversal(n, helper);
		return helper.isBST();
	}

	private static BSTHelper inorder_traversal(Node n, BSTHelper helper) {
		if (n == null || !helper.isBST()) {
			return helper;
		}
		inorder_traversal(n.left, helper);
		if (!helper.isBST()) {
			return helper;
		}
		if (helper.getPrevInorder() != null && helper.getPrevInorder() > n.val) {
			helper.setBST(false);
			return helper;
		}
		helper.setPrevInorder(n.val);
		inorder_traversal(n.right, helper);
		return helper;
	}

	private static class CousionHelper {
		private Node parent1 = null;
		private Node parent2 = null;
		private int level1 = -1;
		private int level2 = -1;
	}

	public static boolean areCousions(Node tree, Node t1, Node t2) {

		CousionHelper helper = new CousionHelper();
		preOrderTraversal(tree, t1, t2, helper, 0);

		if (helper.parent1 != null && helper.parent2 != null
				&& helper.parent1 != helper.parent2
				&& helper.level1 == helper.level2) {
			return true;
		}

		return false;
	}

	public static void preOrderTraversal(Node tree, Node t1, Node t2,
			CousionHelper helper, int level) {

		if (tree == null) {
			return;
		}

		System.out.println("Node : " + tree.val + " Level : " + level);

		if (tree.left == t1 || tree.right == t1) {
			helper.parent1 = tree;
			helper.level1 = level;
		}
		if (tree.left == t2 || tree.right == t2) {
			helper.parent2 = tree;
			helper.level2 = level;
		}

		preOrderTraversal(tree.left, t1, t2, helper, level + 1);
		preOrderTraversal(tree.right, t1, t2, helper, level + 1);
	}

	public static List<Integer> topView(Node root) {
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		LinkedList<Integer> topView = new LinkedList<Integer>();
		int left, right, center;
		left = right = center = 0;
		q.add(root);
		while (!q.isEmpty()) {
			Node n = q.poll();
			q.add(n.left);
			q.add(n.right);
			if (n != null) {
				topView.addFirst(n.val);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		Node l1 = root.left = new Node(5);
		Node l2 = root.right = new Node(20);
		l1.left = new Node(2);
		l1.right = new Node(8);
		l2.left = new Node(12);
		l2.right = new Node(25);
		// System.out.println(areCousions(root, l1.left, l2.right));
	}
}
