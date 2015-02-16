package gonzalez.tatiana;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Cocinero extends Thread{
	private int id;
	private Semaphore semaforoSarten;
	private Semaphore semaforoFuego;
	//private CountDownLatch contadorFin;
	private Random rng = new Random();
	private int pasosReceta;
	
	//Constructor
	public Cocinero(int id, Semaphore semaforoSarten, Semaphore semaforoFuego){//, CountDownLatch contadorFin){
		this.id = id;
		this.semaforoFuego = semaforoFuego;
		this.semaforoSarten = semaforoSarten;
		this.pasosReceta = rng.nextInt(6) + 2; //he supuesto un mínimo de dos pasos 
	}//fin constructor
	
	
	/**
	 * Al entrar en la cocina,anuncia su entrada
	 * Se prepara un tiempo entre 5-15 segundos (llamando al metodo auxiliar prepararse()
	 * Intenta coger sartén. Será semaforoSarten quien le tenga a la espera hasta que haya una disponible.
	 * Anuncia cuantos pasos tiene su receta.
	 * Intenta acceder al fuego
	 * Durante los pasos de la receta 1) usa el fuego y 2) realiza tareas de entre 2-10 segundos (llamadaamétodo auxiliar)
	 * Anuncia que termina la receta y libera el fuego.
	 * Anuncia que ya no necesita la sartén y la libera.
	 * 
	 */
	public void run(){
		System.out.println("Cocinero " +id +" entrando en la cocina. Preparándose...");
		try{
		//Al entrar en la cocina, invierte entre 5 y 15 segundos en prepararse
		prepararse();
		//Se pone a la fila para coger una sarten. Si no hay, espera.
		semaforoSarten.acquire();
		//En cuanto coge sarten anuncia cuantas veces va a necesitar el fogon (máximo 6)
		System.out.println("Cocinero " +id +" haciendo receta de " +pasosReceta +" pasos.");
		semaforoFuego.acquire();
		//Entre uso y uso del fuego, realiza tareasde 2-10 segundos
		//Usa el fuego y realiza tarea, tantas vecescomo pasos haya
		for (int i=1; i<=pasosReceta; i++) {
			System.out.println("Cocinero " +id +" usando el fuego. Paso " +i );
			tareasSinSarten();
		}
		//Deja elfuego libre
		System.out.println("Cocinero " +id +" termina la receta. Deja el fuego libre.");
		semaforoFuego.release();
		
		//Deja la sarten libre
		System.out.println("Cocinero " +id +" deja la sartén libre.");
		semaforoSarten.release();
		}
		catch(Exception e){//No hago nada :( 
			}
		}

	private void prepararse() throws InterruptedException{
		long milisegundos = (rng.nextInt(11) + 5) * 1000;
		Thread.sleep(milisegundos);
	}
	private void tareasSinSarten() throws InterruptedException{
		long milisegundos = (rng.nextInt(9) + 2) * 1000;
		Thread.sleep(milisegundos);
	}
	
}
