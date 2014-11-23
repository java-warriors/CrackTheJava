package com.javawarriors.leetcode;

import java.util.HashMap;

public class LRUCache {
	private static class LinkedListM {
		private Entry header = new Entry(null, null, null);
		
		private int size = 0;

		LinkedListM(){
			header.next = header.previous = header;
		}
		
		private static class Entry {
			Value element;
			Entry next;
			Entry previous;

			Entry(Value element, Entry next, Entry previous) {
				this.element = element;
				this.next = next;
				this.previous = previous;
			}
		}
		
		public Entry add(Value e) {
			return addBefore(e, header);
		}

		private Entry addBefore(Value e, Entry entry) {
			Entry newEntry = new Entry(e, entry, entry.previous);
			newEntry.previous.next = newEntry;
			newEntry.next.previous = newEntry;
			size++;
			return newEntry;
		}

		private Value remove(Entry e) {
			Value result = e.element;
			e.previous.next = e.next;
			e.next.previous = e.previous;
			e.next = e.previous = null;
			e.element = null;
			size--;
			return result;
		}

		public Value poll() {
			if (size == 0)
				return null;
			return removeFirst();
		}

		public Value removeFirst() {
			return remove(header.next);
		}

	}

	HashMap<Integer, LinkedListM.Entry> lruCache;
	LinkedListM lruQueue;
	int capacity;
	
	private class Value{
		int key;
		int value;
		Value(int key, int value){
			this.key = key;
			this.value = value;
		}
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
		lruCache = new HashMap<Integer, LinkedListM.Entry>();
		lruQueue = new LinkedListM();
	}

	public int get(int key) {
		int value = -1;
		if (lruCache.containsKey(key)) {
			LinkedListM.Entry entry = lruCache.remove(key);
			value = entry.element.value;
			lruQueue.remove(entry);
			lruCache.put(key, lruQueue.add(new Value(key,value)));
		}
		return value;
	}

	public void set(int key, int value) {
		if (lruCache.containsKey(key)) {
			lruQueue.remove(lruCache.remove(key));
		}
		if (lruCache.size() == capacity) {
			lruCache.remove(lruQueue.poll().key);
		}		
		lruCache.put(key, lruQueue.add(new Value(key,value)));
	}
}