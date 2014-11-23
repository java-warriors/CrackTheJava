package com.javawarriors.learning;

import java.util.ArrayList;
import java.util.List;

public class MoveNSync {
	public static String multiply(String a, String b) {
		if (a == null || b == null) {
			return null;
		}
		String small, large;
		if (a.length() < b.length()) {
			small = a;
			large = b;
		} else {
			small = b;
			large = a;
		}
		List<String> array = new ArrayList<String>();
		for (int i = small.length() - 1; i >= 0; i--) {
			StringBuilder sb = new StringBuilder();
			for (int k = 0; k < small.length() - 1 - i; k++) {
				sb.append(0);
			}
			int carry = 0;
			for (int j = large.length() - 1; j >= 0; j--) {
				int x = Character.getNumericValue(large.charAt(j));
				int y = Character.getNumericValue(small.charAt(i));
				int product = (x * y + carry) % 10;
				carry = (x * y + carry) / 10;
				sb.insert(0, product);
			}
			if (carry > 0) {
				sb.insert(0, carry);
			}
			array.add(sb.toString());
		}
		return sumOfArray(array);
	}

	public static String sumOfArray(List<String> array) {
		String sum = null;
		for (String str : array) {
			sum = sum(sum, str);
		}
		return sum;
	}

	public static String sum(String a, String b) {
		if (a == null) {
			return b;
		} else if (b == null) {
			return a;
		}
		String small, large;
		if (a.length() < b.length()) {
			small = a;
			large = b;
		} else {
			small = b;
			large = a;
		}
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = large.length() - 1; i >= 0; i--) {
			int x = 0;
			if (i - (large.length() - small.length()) >= 0) {
				x = Character.getNumericValue(small.charAt(i
						- (large.length() - small.length())));
			}
			int y = Character.getNumericValue(large.charAt(i));
			int sum = (x + y + carry) % 10;
			carry = (x + y + carry) / 10;
			sb.insert(0, sum);
		}
		if (carry > 0) {
			sb.insert(0, carry);
		}
		return sb.toString();
	}

	public static String stringOutputBigFactorial(int x) {
		String answer = "1";
		for (int i = 2; i <= x; i++) {
			answer = multiply(answer, Integer.toString(i));
		}
		return answer;
	}

	public static void main(String args[]) {
		System.out.println(stringOutputBigFactorial(Integer.parseInt(args[0])));
	}
}
