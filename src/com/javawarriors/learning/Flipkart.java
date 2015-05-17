package com.javawarriors.learning;

import java.util.ArrayList;
import java.util.List;

public class Flipkart {
	static int numberOfPaths(int[][] a, int M, int N) {
		// return recursive_sol(a, 0, 0, M, N);
		return dp_sol(a, M, N);
	}

	static int recursive_sol(int[][] a, int i, int j, int M, int N) {
		if (i == M - 1 && j == N - 1) {
			return 1;
		}
		int right = 0, down = 0;
		if (j + 1 < N && a[i][j + 1] == 1) {
			right = recursive_sol(a, i, j + 1, M, N);
		}
		if (i + 1 < N && a[i + 1][j] == 1) {
			down = recursive_sol(a, i + 1, j, M, N);
		}
		return (right + down) % (1000000007);
	}

	static int dp_sol(int[][] a, int M, int N) {

		int[][] path = new int[M][N];

		boolean flag = true;

		for (int i = 0, j = 0; i < M; i++) {
			if (a[i][j] == 0) {
				flag = false;
			}
			path[i][j] = flag ? a[i][j] : 0;
		}

		flag = true;

		for (int i = 0, j = 0; j < N && a[i][j] != 0; j++) {
			if (a[i][j] == 0) {
				flag = false;
			}
			path[i][j] = flag ? a[i][j] : 0;
		}

		for (int i = 1; i < M; i++) {
			for (int j = 1; j < N; j++) {
				if (a[i][j] == 0) {
					path[i][j] = 0;
				} else {
					path[i][j] = (path[i - 1][j] + path[i][j - 1]) % 1000000007;
				}
			}
		}

		return path[M - 1][N - 1];
	}

	public static class Node {
		List<Node> children;
		int id;
		public void addChild(Node child) {
			this.children.add(child);
		}

		public int max_length() {
			return this.dfs(this);
		}

		private int dfs(Node n) {
			if (n == null) {
				return 0;
			}
			if (n.children == null || n.children.size() == 0) {
				return 1;
			}
			int depth = -1;
			for (int i = 0; i < n.children.size(); i++) {
				int d = dfs(n.children.get(i));
				if (depth < d) {
					depth = d;
				}
			}

			return depth + 1;
		}
	}

	public static void main(String[] args) {
		// int[][] mat1 = new int[][] { { 1, 1 }, { 0, 1 } };
		// System.out.println(numberOfPaths(mat1, 2, 2));
		Node n = new Node();
		n.id = 1;
		List<Node> nlist1 = new ArrayList<Node>();
		Node n11 = new Node();
		n11.id = 2;
		Node n12 = new Node();
		n12.id = 3;
		Node n13 = new Node();
		n13.id = 4;
		nlist1.add(n11);
		nlist1.add(n12);
		nlist1.add(n13);
		n.children = nlist1;

		List<Node> nlist11 = new ArrayList<Node>();
		Node n21 = new Node();
		n21.id = 5;
		Node n22 = new Node();
		n22.id = 6;
		nlist11.add(n21);
		nlist11.add(n22);
		n11.children = nlist11;

		List<Node> nlist22 = new ArrayList<Node>();
		Node n31 = new Node();
		n31.id = 7;
		nlist22.add(n31);
		n22.children = nlist22;

		System.out.println(n.max_length());
	}
}
