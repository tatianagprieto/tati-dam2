package vk.tati;

public class CincoHilosMain {
	static int contadorHilos = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		crearHilo();
	}

	public static void crearHilo(){
		if (contadorHilos <5){
			String nombre, nombreHijo;
			nombre = Thread.currentThread().getName();
			System.out.println("Soy " + nombre +" comenzando");
			contadorHilos++;
			nombreHijo = "Hilo " +contadorHilos;
			Thread hilo = new Thread (nombreHijo){
				public void run(){
					crearHilo();
				}
			};
			System.out.println("Procesando " +nombreHijo);
			hilo.start();
			try{
				hilo.join();
				System.out.println(nombre +" ha terminado-.");
			}catch(InterruptedException ie){}
		}
		else{System.out.println("Soy el quinto hilo y no puedo crear más :( Termino aquí.");}
	}
}
