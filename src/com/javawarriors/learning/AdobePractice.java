package com.javawarriors.learning;

public class AdobePractice {
	public static class Node {
		int value;
		Node next;

		Node(int val) {
			value = val;
		}
	}

	public static Node reverse(Node start) {
		if (start.next == null) {
			return start;
		}
		Node newStart = reverse(start.next);
		start.next.next = start;
		start.next = null;
		return newStart;
	}

	public static void print(Node start) {
		if (start == null) {
			return;
		} else {
			System.out.print(start.value);
			if (start.next != null) {
				System.out.print("->");
			}
			print(start.next);
		}
	}

	static int isIntegerPalindrome(int a) {
		a = Math.abs(a);
		int fa = a;
		int ra = 0;
		while (a > 0) {
			ra = ra * 10 + a % 10;
			a = a / 10;
		}
		return (fa == ra) ? 1 : 0;
	}

	public static int rowWithMaxZeros(int[][] mat) {
		int row = 0;
		int col = 0;
		int rowNum = 0;
		while (true) {
			if (mat[row][col] == 1) {
				col++;
				rowNum = row;
			} else {
				row++;
			}
			if (row >= mat.length || col >= mat.length)
				break;
		}
		return rowNum;
	}

	static int multiplyNumbers(int M, int N) {
		/*
		 * For your reference, a function of the prototype int sum(int,int); has
		 * already been defined. When you're going to sum 2 numbers, use the
		 * above function.
		 * 
		 * For instance to sum up M & N, you can call the function sum(M,N) and
		 * it would return M+N.
		 * 
		 * Please avoid the usage of '+' operator and use the function instead
		 */
		if (M < N) {
			M = M + N;
			N = M - N;
			M = M - N;
		}
		int answer = 0;
		if (N > 0) {
			answer = M + multiplyNumbers(M, N - 1);
		}
		return answer;
	}

	public static void main(String[] args) {
		// Node start = null; Node n1 = new Node(10); start = n1; Node n2 = new
		// Node(20); n1.next = n2; Node n3 = new Node(30); n2.next = n3;
		// Node.print(start); start = Node.reverse(start); System.out.println();
		// Node.print(start);
		// System.out.println(palidrome(-12));
		// System.out.println(minSeqOf1s(3));
		// int[][] mat = new int[][] { { 1, 1, 1, 0, 0 }, { 1, 1, 1, 1, 0 },
		// { 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0 } };
		
		//System.out.println(areBracketsMatched("[1]".toCharArray()));

		// System.out.println(isSubsetSumPossible(new int[] {10,1,2,7,6,1,5},
		// 50));
		System.out.println(isIntegerPalindrome(12311));
	}
}
