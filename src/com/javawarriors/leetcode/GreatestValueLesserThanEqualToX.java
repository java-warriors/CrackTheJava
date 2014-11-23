package com.javawarriors.leetcode;

public class GreatestValueLesserThanEqualToX {

	public static Integer findGreatestValueLesserThanOrEqualToX(int[] arr, int x) {
		if (arr == null) {
			throw new NullPointerException(" The input array is null. ");
		}
		if (arr.length >= 1) {
			if (arr[0] >= x) {
				return null;
			} else if (arr[arr.length - 1] < x) {
				return arr[arr.length - 1];
			} else {
				return findGreatestValueLesserThanOrEqualToX(arr, x, 0,
						arr.length - 1);
			}
		} else {
			return null;
		}
	}

	private static Integer findGreatestValueLesserThanOrEqualToX(int[] arr,
			int x, int lb, int ub) {
		final int mid = (lb + ub) / 2;
		if (arr[mid] < x && arr[mid + 1] >= x) {
			return arr[mid];
		}
		if (arr[mid] < x) {
			return findGreatestValueLesserThanOrEqualToX(arr, x, mid + 1, ub);
		} else {
			return findGreatestValueLesserThanOrEqualToX(arr, x, lb, mid);
		}
	}

	public static void main(String args[]) {
		System.out.println(findGreatestValueLesserThanOrEqualToX(new int[] { 12,
				20, 30, 40, 50 }, 55));
	}
}