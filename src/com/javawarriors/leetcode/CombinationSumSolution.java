package com.javawarriors.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumSolution{
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> current = new ArrayList<Integer>();
		Arrays.sort(num);
		computeSubsetSum(num, target, sol, current, 0);
		return sol;
	}

	private boolean computeSubsetSum(int[] num, int target,
			ArrayList<ArrayList<Integer>> sol, ArrayList<Integer> current,
			int index) {
		if (index == num.length && target != 0 || target < 0) {
			return false;
		}
		if (target == 0) {
			if(!sol.contains(current)){
				ArrayList<Integer> validSubset = new ArrayList<Integer>(
						current.size());
				for (Integer i : current) {
					validSubset.add(i);
				}
				sol.add(validSubset);
			}			
			return true;
		}
		ArrayList<Integer> current2 = new ArrayList<Integer>(current.size());
		for (Integer i : current) {
			current2.add(i);
		}
		current2.add(num[index]);
		boolean left = computeSubsetSum(num, target - num[index], sol,
				current2, index + 1);
		boolean right = computeSubsetSum(num, target, sol, current, index + 1);
		return left || right;
	}
}
