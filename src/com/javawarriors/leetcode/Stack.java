package com.javawarriors.leetcode;

public class Stack {

	LinkNode top;

	private static class LinkNode {
		int data;
		LinkNode next;

		LinkNode(int data) {
			this.data = data;
		}
	}

	Stack() {
		top = new LinkNode(-1);
		top.next = null;
	}

	public void push(Integer data) {
		LinkNode node = new LinkNode(data);
		node.next = top.next;
		top.next = node;
	}

	public Integer pop() {
		if (top.next == null) {
			return null;
		}	
		int val = top.next.data;
		top.next = top.next.next;
		return val;
	}

	public void print() {
		LinkNode temp = top.next;
		System.out.println("\nStack Print : ");
		while(temp != null){
			System.out.print(temp.data);
			temp = temp.next;
		}
	}
}
