package com.javawarriors.leetcode;

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		int minima = -1;
		int maxima = -1;
		int currentMinima = -1;
		int currentMaxima = -1;
		int maxProfit = 0;
		boolean searchForMinima = true;
		int i = -1;
		for (i = 1; i < prices.length; i++) {
			if (searchForMinima) {
				if (prices[i] > prices[i - 1]) {
					currentMinima = prices[i - 1];
					if (minima == -1 || currentMinima < minima) {
						minima = currentMinima;
					}
					searchForMinima = false;
				}
			} else if (!searchForMinima) {
				if (prices[i] < prices[i - 1]) {
					currentMaxima = prices[i - 1];
					if (maxima == -1 || currentMaxima > maxima) {
						maxima = currentMaxima;
					}
					searchForMinima = true;
				}
			}
		}
		if (!searchForMinima) {
			currentMaxima = prices[i - 1];
			if (maxima == -1 || currentMaxima > maxima) {
				maxima = currentMaxima;
			}
		}
		return maxima - minima;
	}
}
