package com.javawarriors.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// http://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
public class SubstringWithConcatenationSolution {
	public class KMPAlgo {
		public int[] preProcessPattern(char[] ptrn) {
			int i = 0, j = -1;
			int ptrnLen = ptrn.length;
			int[] b = new int[ptrnLen + 1];
			b[i] = j;
			while (i < ptrnLen) {
				while (j >= 0 && ptrn[i] != ptrn[j]) {
					// if there is mismatch consider next widest border
					j = b[j];
				}
				i++;
				j++;
				b[i] = j;
			}
			return b;
		}

		public void searchSubString(char[] text, char[] ptrn,
				HashMap<Integer, Integer> invalidSubstrings) {
			int i = 0, j = 0;
			// pattern and text lengths
			int ptrnLen = ptrn.length;
			int txtLen = text.length;
			// initialize new array and preprocess the pattern
			int[] b = preProcessPattern(ptrn);
			while (i < txtLen) {
				while (j >= 0 && text[i] != ptrn[j]) {
					j = b[j];
				}
				i++;
				j++;
				// a match is found
				if (j == ptrnLen) {
					invalidSubstrings.put((i - ptrnLen), ptrnLen);
					j = b[j];
				}
			}
		}
	}

	private class SearchListUtility {
		String[] L;
		boolean[] flag;

		SearchListUtility(String[] L) {
			this.L = L;
			this.flag = new boolean[L.length];
		}

		public boolean binarySearch(int start, int end, String str) {
			int current;
			while (start <= end) {
				current = (start + end) / 2;
				int result = L[current].compareTo(str);
				if (result == 0 && setFlag(current)) {
					return true;
				} else if (result < 0) {
					return binarySearch(current + 1, end, str);
				} else if (result > 0) {
					return binarySearch(start, current - 1, str);
				} else {
					return (binarySearch(current + 1, end, str) || binarySearch(
							start, current - 1, str));
				}
			}
			return false;
		}

		public boolean findAndSetFlag(String str) {
			int start = 0, end = L.length - 1;
			return binarySearch(start, end, str);
		}

		public boolean setFlag(int i) {
			if (flag[i]) {
				return false;
			} else {
				flag[i] = true;
				return true;
			}
		}
	}

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.

		ArrayList<Integer> solution = new ArrayList<Integer>();
		int sizeOfSubstring = L[0].length();
		if (S.length() < L.length * sizeOfSubstring) {
			return solution;
		}
		Arrays.sort(L);
		KMPAlgo kmp = new KMPAlgo();
		int indexUnderConsideration;
		SearchListUtility slu;
		HashMap<Integer, Integer> invalidSubstrings = new HashMap<Integer, Integer>();
		for (indexUnderConsideration = 0; indexUnderConsideration < S.length()
				- L.length * sizeOfSubstring + 1; indexUnderConsideration++) {
			slu = new SearchListUtility(L);
			int numberOfSubstringsFound = 0;
			for (int i = indexUnderConsideration; i < S.length()
					- sizeOfSubstring + 1; i = i + sizeOfSubstring) {
				if (invalidSubstrings.containsKey(i)
						&& invalidSubstrings.get(i) <= L.length
								* sizeOfSubstring
								- (i - indexUnderConsideration)) {
					break;
				}
				if (!slu.findAndSetFlag(S.substring(i, i + sizeOfSubstring))) {
					String invalidString = S.substring(indexUnderConsideration,
							i + sizeOfSubstring);
					kmp.searchSubString(S.toCharArray(),
							invalidString.toCharArray(), invalidSubstrings);
					break;
				}
				if (++numberOfSubstringsFound == L.length) {
					solution.add(indexUnderConsideration);
					break;
				}
			}
		}
		return solution;
	}
}