package com.javawarriors.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileExample {
	static volatile int volatileCount = 0;
	static AtomicInteger atomicCount = new AtomicInteger(0);

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					}
					for (int i = 0; i < 100; i++) {
						System.out.println("I am a thread, My name is "
								+ Thread.currentThread().getName()
								+ " , My atomicCount is "
								+ atomicCount.incrementAndGet()
								+ " My volatile count is " + ++volatileCount);
					}
				}
			}).start();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		System.out.println("Expected count : 10000, Atomic count : "
				+ atomicCount.get() + " Volatile count : " + volatileCount);
	}
}