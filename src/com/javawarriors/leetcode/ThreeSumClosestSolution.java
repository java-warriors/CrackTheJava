package com.javawarriors.leetcode;

import java.util.Arrays;

public class ThreeSumClosestSolution {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int minDiff = num[0] + num[1] + num[2] - target;
		int S = num[0] + num[1] + num[2];
		for (int i = 0; i < num.length - 2; i++) {
			for (int j = i + 1; j < num.length - 1; j++) {
				int preDiff = num[i] + num[j] + num[j + 1] - target;
				for (int k = j + 1; k < num.length; k++) {
					int s = num[i] + num[j] + num[k];
					int diff = s - target;
					if (diff * diff > preDiff * preDiff)
						break;
					preDiff = diff;
					if (diff * diff < minDiff * minDiff) {
						minDiff = diff;
						S = s;
					}
				}
			}
		}
		return S;
	}
}