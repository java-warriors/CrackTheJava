package com.javawarriors.leetcode;

public class ReverseWordsInString {
	private char[] reverseArr(char[] str, int i, int j) {
		while (i < j) {
			char t = str[i];
			str[i] = str[j];
			str[j] = t;
			i++;
			j--;
		}
		return str;
	}

	private int cleanStr(char[] str) {
		boolean valid = true;
		int moveback = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == 32) {
				if (valid) {
					valid = false;
				} else {
					moveback++;
				}
			} else {
				valid = true;
				if (moveback > 0) {
					str[i - moveback] = str[i];
					str[i] = ' ';
				}
			}
		}
		return str.length - moveback;
	}

	public String reverseWords(String s) {
		s = s.trim();
		if (s.length() > 0) {
			char[] str = s.toCharArray();
			int len = cleanStr(str);
			str = reverseArr(str, 0, len - 1);
			int l = 0;
			int r = 0;
			while (r < len) {
				if (str[r] == 32) {
					if (l < r - 1) {
						str = reverseArr(str, l, r - 1);
					}
					l = r + 1;
				}
				r++;
			}
			if (l < r) {
				str = reverseArr(str, l, r - 1);
			}
			s = new String(str);
			return s.substring(0, len);
		}
		return s;
	}
}
