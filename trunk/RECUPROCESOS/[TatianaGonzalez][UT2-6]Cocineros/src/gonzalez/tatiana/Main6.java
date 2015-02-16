package gonzalez.tatiana;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int NUMERO_COCINEROS = 6;
		int NUMERO_FUEGOS = 2;
		int NUMERO_SARTENES = 3;
		
		ArrayList<Cocinero> cocineros = new ArrayList<Cocinero>();
		Semaphore semSarten = new Semaphore(NUMERO_SARTENES);
		Semaphore semFuego = new Semaphore(NUMERO_FUEGOS);
		for (int i=0; i<NUMERO_COCINEROS; i++) cocineros.add(new Cocinero(i, semSarten, semFuego));
		System.out.println("Se abre la cocina");
		System.out.println();
		for (int i=0; i<NUMERO_COCINEROS; i++) cocineros.get(i).start();
	}

}
