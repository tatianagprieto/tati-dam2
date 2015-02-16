package gonzalez.tatiana;

import java.util.Random;

/**
 * 
 * @author tatiana
 *
 */

public class Coche extends Thread{
	private int id;
	private boolean buscandoPlaza;
	private Barrera barrera;
	Random rng = new Random();
	public Coche(int id, Barrera barrera){
		this.id = id;
		this.buscandoPlaza = true;
		this.barrera = barrera;
	}
	
	public void run(){
		while(buscandoPlaza){
			if(barrera.solicitarPlaza(id)) {
				System.out.println("Coche " +id + " aparcando en plaza " +barrera.buscarCoche(id));
				buscandoPlaza = false;
				try {
					//dormir entre 0 y 2 segundos
					Thread.sleep(rng.nextInt(3)*1000);
					System.out.println("  Coche " +id +" saliendo del parking.");
					barrera.liberarPlaza(id);
					//Descomentar la siguiente línea si queremos que el coche vuelva a optar por plaza al salir
					//buscandoPlaza = true;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}//fin run
}
