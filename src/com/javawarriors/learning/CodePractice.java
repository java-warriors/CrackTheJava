package com.javawarriors.learning;

public class CodePractice {
	public void fun1(int n) {
		int i = 1;
		int s = 1;
		while (s <= n) {
			i++;
			s = s + i;
			System.out.print("*");
		}
	}

	public void fun2(int n) {
		for (int i = n / 2; i <= n; i++) {
			for (int j = 1; j <= n; j = 2 * j) {
				System.out.print("*");
			}
		}
	}
	
	public static void main(String[] args){
		CodePractice cp = new CodePractice();
		cp.fun1(5);
		System.out.println();
		cp.fun2(5);
	}
}
