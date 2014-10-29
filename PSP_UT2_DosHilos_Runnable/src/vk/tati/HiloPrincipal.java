package vk.tati;

public class HiloPrincipal {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creamos dos hilos
		//Para ello, le pasamos al constructor de Thread la clase que contiene el método run que se ejecutará al iniciar el hilo
		//En este caso, la clase que contiene nuestro run() es hilo contador (la instanciamos dentro de la llamada al contador, podemos hacer esto porque no vamos a usar el objeto de tipo HiloContador en todo el código).
		Thread hilo1 = new Thread(new HiloContador("Hilo 1"));
		Thread hilo2 = new Thread(new HiloContador("Hilo 2"));
				
		hilo1.start();
		hilo2.start();
	}

}
