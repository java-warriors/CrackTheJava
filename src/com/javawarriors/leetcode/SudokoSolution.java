package com.javawarriors.leetcode;

// http://oj.leetcode.com/problems/valid-sudoku/
public class SudokoSolution {
	private class Hashing {
		char[] Flag = new char[9];

		public boolean checkAndSetFlag(char key) {
			if (key == '.') {
				return true;
			}
			if (Flag[Character.getNumericValue(key) - 1] == '1') {
				return false;
			} else {
				Flag[Character.getNumericValue(key) - 1] = '1';
				return true;
			}
		}
	}

	public boolean isValidSudoku(char[][] board) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		Hashing rowCheck = null;
		Hashing[] columnCheckArray = new Hashing[9];
		Hashing[] blockCheckArray = new Hashing[9];
		int k = 0;
		for (int i = 0; i < 9; i++) {
			rowCheck = new Hashing();
			for (int j = 0; j < 9; j++) {
				if (i == 0) {
					Hashing columnCheck = new Hashing();
					columnCheckArray[j] = columnCheck;
				}
				if (i % 3 == 0) {
					if (j % 3 == 0) {
						Hashing columnCheck = new Hashing();
						blockCheckArray[k++] = columnCheck;
					}
				}
				if (columnCheckArray[j].checkAndSetFlag(board[i][j])
						&& rowCheck.checkAndSetFlag(board[i][j])
						&& blockCheckArray[3 * (i / 3) + (j / 3)]
								.checkAndSetFlag(board[i][j])) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
	}
}