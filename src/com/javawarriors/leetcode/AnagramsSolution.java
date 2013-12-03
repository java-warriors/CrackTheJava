package com.javawarriors.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class AnagramsSolution {
	private static class Signature {
		private static HashMap<Character, Integer> compute(String str) {
			HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
			for (int i = 0; i < str.length(); i++) {
				if (countMap.containsKey(str.charAt(i))) {
					int value = countMap.get(str.charAt(i));
					countMap.put(str.charAt(i), value + 1);
				} else {
					countMap.put(str.charAt(i), 1);
				}
			}
			countMap.put('L', str.length());
			return countMap;
		}
	}

	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> anagrams = new ArrayList<String>();
		HashMap<HashMap<Character, Integer>, String> signatureMap = new HashMap<HashMap<Character, Integer>, String>();
		for (int i = 0; i < strs.length; i++) {
			HashMap<Character, Integer> signature = Signature.compute(strs[i]);
			if (signatureMap.containsKey(signature)) {
				if (!signatureMap.get(signature).equals("1")) {
					anagrams.add(signatureMap.get(signature));
					signatureMap.put(signature, "1");
				}
				anagrams.add(strs[i]);
			} else {
				signatureMap.put(signature, strs[i]);
			}
		}
		return anagrams;
	}
}