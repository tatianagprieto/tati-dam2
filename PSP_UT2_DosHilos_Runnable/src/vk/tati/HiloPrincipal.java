package vk.tati;

public class HiloPrincipal {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread hilo1 = new Thread(new HiloContador("Hilo 1"));
		Thread hilo2 = new Thread(new HiloContador("Hilo 2"));
				
		hilo1.start();
		hilo2.start();
	}

}
