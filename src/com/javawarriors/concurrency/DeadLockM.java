package com.javawarriors.concurrency;

public class DeadLockM {
	public static class A {
		public synchronized void a1(B instance) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("This is class A method a1");
			instance.b2();
		}
		public synchronized void a2() {
			System.out.println("This is class A method a2");
		}
	}

	public static class B {
		public synchronized void b1(A instance) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("This is class B method b1");
			instance.a2();
		}
		public synchronized void b2() {
			System.out.println("This is class B method b2");
		}
	}
	
	public static void main(String args[]){
		final A a = new A();
		final B b = new B();
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				a.a1(b);
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				b.b1(a);
			}
		});
		
		t1.start();
		t2.start();
	}
}
