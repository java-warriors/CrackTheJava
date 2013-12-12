package com.javawarriors.leetcode;

public class Solution {
	private static class Stack {

		LinkNode top;

		private static class LinkNode {
			String data;
			LinkNode next;

			LinkNode(String data) {
				this.data = data;
			}
		}

		Stack() {
			top = new LinkNode("");
			top.next = null;
		}

		public void push(String data) {
			LinkNode node = new LinkNode(data);
			node.next = top.next;
			top.next = node;
		}

		public String pop() {
			if (top.next == null) {
				return null;
			}
			String val = top.next.data;
			top.next = top.next.next;
			return val;
		}
	}

	public String simplifyPath(String path) {
		String ans = "";
		String[] tokens = path.split("/");
		Stack s = new Stack();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].isEmpty()) {
				continue;
			} else {
				if (tokens[i].equals("..")) {
					s.pop();
				} else if (!tokens[i].equals(" ") && !tokens[i].equals(".")) {
					s.push(tokens[i]);
				}
			}
		}
		while (true) {
			String tmp = s.pop();
			if (tmp == null) {
				break;
			}
			ans = "/" + tmp + ans;
		}
		return ans.isEmpty() ? "/" : ans;
	}
}