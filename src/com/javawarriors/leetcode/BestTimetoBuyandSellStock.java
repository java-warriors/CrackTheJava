package com.javawarriors.leetcode;

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		int currentMinima = -1;
		int currentMaxima = -1;
		int maxProfit = 0;
		int currentProfit = 0;
		boolean searchForMinima = true;
		int i = -1;
		for (i = 1; i < prices.length; i++) {
			if (searchForMinima) {
				if (prices[i] > prices[i - 1]) {
					int t = -1;
					if (currentMaxima > 0) {
						t = currentProfit - (currentMaxima - currentMinima);
					}
					if (t > 0) {
						currentProfit = t;
					} else {
						if (maxProfit < currentProfit) {
							maxProfit = currentProfit;
						}
						currentProfit = 0;
					}
					currentMinima = prices[i - 1];
					searchForMinima = false;
				}
			} else if (!searchForMinima) {
				if (prices[i] < prices[i - 1]) {
					currentMaxima = prices[i - 1];
					searchForMinima = true;
					currentProfit = currentProfit
							+ (currentMaxima - currentMinima);
				}
			}
		}
		if (!searchForMinima) {
			currentMaxima = prices[i - 1];
			currentProfit = currentProfit + (currentMaxima - currentMinima);
		}
		if (maxProfit < currentProfit) {
			maxProfit = currentProfit;
		}
		return maxProfit;
	}
}
