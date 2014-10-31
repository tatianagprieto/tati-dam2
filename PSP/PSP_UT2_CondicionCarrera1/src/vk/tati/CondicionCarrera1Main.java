package vk.tati;

public class CondicionCarrera1Main {
	public static Contador cont;
	public static void main(String[] args) {
		cont = new Contador(0);
		Hilo1 h1 = new Hilo1();
		Hilo2 h2 = new Hilo2();
		h1.start();
		h2.start();
		try{
			h1.join();
			h2.join();
		}catch(InterruptedException ie){}
		System.out.println("El valor esperado es " +cont.NUMVECES);
		System.out.println("El valor obtenido es " + cont.getValue());
		
	}
}
