package com.javawarriors.leetcode;

import java.util.Arrays;

public class StringMultiplySolution {
	public String multiply(String num1, String num2) {
		String multiplier, multiplicand;
		char[] answer = new char[num1.length() + num2.length()];
		Arrays.fill(answer, '0');
		int i, j;
		if (num1.length() < num2.length()) {
			multiplier = num1;
			multiplicand = num2;
		} else {
			multiplier = num2;
			multiplicand = num1;
		}
		for (i = multiplier.length() - 1; i >= 0; i--) {
			if (multiplier.charAt(i) <= 48)
				continue;
			int carry = 0;
			char[] num = new char[multiplicand.length()];
			for (j = multiplicand.length() - 1; j >= 0; j--) {
				int p = Character.getNumericValue(multiplicand.charAt(j))
						* Character.getNumericValue(multiplier.charAt(i))
						+ carry;
				num[j] = (char) (p % 10 + 48);
				carry = p / 10;
			}
			sum(answer, num, multiplier.length() - 1 - i, carry);
		}
		i = 0;
		while (i < answer.length && answer[i] == '0') {
			i++;
		}
		if (i == answer.length)
			answer[--i] = 48;
		return String.valueOf(answer, i, answer.length - i);
	}

	private void sum(char[] answer, char[] num, int shift, int carry1) {
		int index = answer.length - 1 - shift;
		int carry2 = 0;
		for (int i = num.length - 1; i >= 0; i--) {
			int s = Character.getNumericValue(answer[index])
					+ Character.getNumericValue(num[i]) + carry2;
			answer[index--] = (char) (s % 10 + 48);
			carry2 = s / 10;
		}
		if (index >= 0 && carry1 + carry2 > 0)
			answer[index] = (char) (carry1 + carry2 + 48);
	}
}
