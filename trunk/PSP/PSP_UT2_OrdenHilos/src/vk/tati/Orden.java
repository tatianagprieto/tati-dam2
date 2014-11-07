package vk.tati;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * 
 * Proyecto UT2_OrdenEjecucionHilos

Crear una clase llamada Orden que cree 2 hilos de la clase Hilo y fuerce que la escritura del segundo hilo  (“Hilo2”) siempre sea anterior a la escritura por pantalla del primero (“Hilo1”).
Se debe crear la clase  Hilo que implementando  la interfaz runnable.  Debe recibir el nombre del hilo. El primero Hilo se llamara “Hilo1” y el segundo Hilo se llamará “Hilo2”. Se usará el nombre del hilo para saber qué hilo debe escribir primero. 
Cada hilo sacará el mensaje:   “Me presento. Soy el Thread “ + nombre_thread

Pista: Se deben usar semáforos (Clase Semaphore). Se debe instanciar en la clase principal y el constructor del Hilo debe recibir el semáforo.
 * @author tatiana
 *
 */

public class Orden {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hilo h = new Hilo();
		Semaphore sm = new Semaphore(1);		
		ArrayList<Thread> hilo = new ArrayList<Thread>(); 
		for (int i=1; i<3; i++){
			hilo.add(new Thread(h, "Hilo " +i));			
		}
		
		for (int i= 1; i>-1; i--){
			try {
				sm.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hilo.get(i).start();
			sm.release();
		}


	}

}
