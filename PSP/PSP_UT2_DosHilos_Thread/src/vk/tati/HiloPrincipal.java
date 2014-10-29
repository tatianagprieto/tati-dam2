package vk.tati;

public class HiloPrincipal {

	public static void main(String[] args) {
		
		//Declaramos e instanciamos dos hilos
		HiloContador hilo1 = new HiloContador("Hilo 1");
		HiloContador hilo2 = new HiloContador("Hilo 2");
		
		//Inicializamos los dos hilos 
		//IMPORTANTE: se hace invocando el método start() NO el método run().
		//El orden de llamada no importa porque no tenemos control sobre como se va a asignar tiempo de procesador a los hilos
		hilo1.start();
		hilo2.start();
	}

}
