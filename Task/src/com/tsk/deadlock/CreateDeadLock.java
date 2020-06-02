package com.tsk.deadlock;

public class CreateDeadLock {

	public static void main(String[] args) {
		final String resource1 = "Microsoft Word";
		final String resource2 = "Microsoft One Note";

		Thread t1 = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread 1: locked Microsoft Word");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
						System.out.println("Thread 1: deadloack");
					}

					synchronized (resource2) {
						System.out.println("Thread 1: locked Microsoft One Note");
					}
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread 2: locked Microsoft One Note");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
						System.out.println("Thread 2: deadloack");
					}

					synchronized (resource1) {
						System.out.println("Thread 2: locked Microsoft Word");
					}
				}
			}
		};

		t1.start();
		t2.start();
	}

}
