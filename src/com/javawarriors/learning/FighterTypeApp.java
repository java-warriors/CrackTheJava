package com.javawarriors.learning;

public class FighterTypeApp {
	public enum FighterType {
		X_WING(1050), Y_WING(1000), TIE(1200);
		private int speed;

		FighterType(int s) {
			speed = s;
		}

		int getSpeed() {
			return speed;
		}
	}
	public static void main(String args[]) {
		FighterType fighterTypes[] = FighterType.values();
		for (FighterType f : fighterTypes) {
			System.out.print("name: " + f.name());
			System.out.println(" speed: " + f.getSpeed());
		}
	}
}