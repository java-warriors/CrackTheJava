package com.javawarriors.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LimeRoad {
	
	// Just coding the logic assuming numbers would lie with integer limits
	// Assuming input is positive as you told me
	public static int netBigIntegerWhichIsPalidrome(int n) {
		if (n < 9) {
			return n + 1;
		}
		if (n == 9) {
			return 11;
		}
		String numString = Integer.toString(n);
		int len = numString.length();
		char t;
		if ((len % 2 == 0 && numString.charAt(len / 2) < numString
				.charAt(len / 2 + 1))
				|| len % 2 == 1
				&& numString.charAt(len / 2 - 1) < numString
						.charAt(len / 2 + 1)) {
			t = (char) (numString.charAt(len / 2) + 1);
		} else {
			t = numString.charAt(len / 2);
		}
		String firstHalf;
		if (len % 2 != 0) {
			firstHalf = numString.substring(0, len / 2) + t;
		} else {
			firstHalf = numString.substring(0, len / 2 - 1) + t;
		}
		char[] secondHalf = new char[len / 2];
		for (int i = 0; i < len / 2; i++) {
			secondHalf[i] = firstHalf.charAt(len / 2 - 1 - i);
		}
		return Integer.parseInt((firstHalf + new String(secondHalf)));
	}

	public static int smallestMissingPositiveInteger(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < arr.length && arr[i] > 0) {
				int temp = arr[arr[i] - 1];
				arr[arr[i] - 1] = arr[i];
				arr[i] = temp;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				return i + 1;
			}
		}
		return 1;
	}

	private static class HelperObj {
		char key;
		int frequency = 0;
		ArrayList<Integer> indexes = new ArrayList<Integer>();
	}

	public static String getQualifiedString(String input, int distance) {

		if (input == null || distance < 0) {
			return null;
		}

		Map<String, HelperObj> charToIndex = new HashMap<String, HelperObj>();
		int maxFrequency = 0;
		int length = input.length();
		for (int i = 0; i < length; i++) {
			HelperObj obj;
			if (charToIndex.containsKey(String.valueOf(input.charAt(i)))) {
				obj = charToIndex.get(String.valueOf(input.charAt(i)));

			} else {
				obj = new HelperObj();
				charToIndex.put(String.valueOf(input.charAt(i)), obj);
				obj.key = input.charAt(i);
			}
			obj.frequency++;
			obj.indexes.add(i);

			if (maxFrequency < obj.frequency) {
				maxFrequency = obj.frequency;
			}
		}

		int numberOfStringHavingMaxFreq = 0;
		for (HelperObj o : charToIndex.values()) {
			if (o.frequency == maxFrequency) {
				numberOfStringHavingMaxFreq++;
			}
		}
		char[] output;
		if (((maxFrequency - 1) * distance + numberOfStringHavingMaxFreq - 1) <= (length - 1)) {
			// not possible to fulfill this requirement
			return null;
		} else {
			output = new char[length];
			int startIndex = 0;
			for (HelperObj o : charToIndex.values()) {
				for (int j = 0; j < o.frequency; j++) {
					char temp = input.charAt(startIndex + j * distance);
					output[startIndex + j * distance] = o.key;
					output[o.indexes.get(j)] = temp;
				}
				startIndex++;
			}
		}
		return new String(output);
	}

	public static void main(String[] args) {
		// LimeRoad lr = new LimeRoad();
		// System.out.println(lr.areCousions(root, l1.left, l2.right));
		// System.out.println(netBigIntegerWhichIsPalidrome(8458));
		// System.out.println(smallestMissingPositiveInteger(new
		// int[]{1,10,2,3}));
		System.out
				.println(LimeRoad.getQualifiedString("abab", 1));
	}

}
