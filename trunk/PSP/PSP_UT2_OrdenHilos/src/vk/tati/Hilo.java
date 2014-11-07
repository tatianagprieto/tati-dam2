package vk.tati;

import java.util.concurrent.Semaphore;

public class Hilo implements Runnable {
	private Semaphore sm;
	public Hilo(Semaphore sm){this.sm = sm;}
	@Override
	public void run() {
		try {
			sm.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Me presento; soy el Thread " +Thread.currentThread().getName());
		sm.release();
	}

}
