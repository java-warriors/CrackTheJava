package com.javawarriors.leetcode;

public class PalindromeSolution {
	public boolean isPalindrome(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		char[] processedArray = s.replaceAll("[^0-9a-zA-Z]+", "").toCharArray();
		int len = processedArray.length;
		boolean isPalindrome = true;
		int i = 0;
		while (len > 0 && i <= (len - 1) / 2) {
			if (processedArray[i] != processedArray[len - i - 1]
					&& Character.toLowerCase(processedArray[i]) != Character
							.toLowerCase(processedArray[len - i - 1])) {
				isPalindrome = false;
				break;
			}
			i++;
		}
		return isPalindrome;
	}
}