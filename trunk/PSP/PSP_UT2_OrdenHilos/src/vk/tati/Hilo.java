package vk.tati;

public class Hilo implements Runnable {

	@Override
	public void run() {
		System.out.println("Me presento; soy el Thread " +Thread.currentThread().getName());
	}

}
