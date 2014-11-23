	package com.javawarriors.concurrency;
	
	class ProducerConsumer {
		public static class Q {
			boolean isEmpty = true;
			int n;
	
			synchronized void get() throws InterruptedException {
				if (isEmpty) {
					wait();
				}
				Thread.sleep(3000);
				System.out.println("Got: " + n);
				isEmpty = true;
				notifyAll();
			}
	
			synchronized void put(int n) throws InterruptedException {
				if (!isEmpty) {
					wait();
				}
				Thread.sleep(2000);
				this.n = n;
				System.out.println("Put: " + n);
				isEmpty = false;
				notifyAll();
			}
		}
	
		public static class Producer implements Runnable {
			Q q;
	
			Producer(Q q) {
				this.q = q;
				new Thread(this, "Producer").start();
			}
	
			public void run() {
				int i = 0;
				while (true) {
					try {
						q.put(i++);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	
		public static class Consumer implements Runnable {
			Q q;
	
			Consumer(Q q) {
				this.q = q;
				new Thread(this, "Consumer").start();
			}
	
			public void run() {
				while (true) {
					try {
						q.get();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	
		public static void main(String args[]) {
			Q q = new Q();
			new Producer(q);
			new Consumer(q);
			System.out.println("Press Control-C to stop.");
		}
	}