package com.javawarriors.learning;

import java.util.Arrays;

public class AlgorithmSet1 {
	public void insertion_sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int v = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > v) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = v;
		}
	}
	public static void main(String[] args){
		AlgorithmSet1 set1 = new AlgorithmSet1();
		int[] arr = {1,4,2,8,14,0,12,15}; 
		set1.insertion_sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
