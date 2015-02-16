package gonzalez.tatiana;

import java.util.Random;

public class Corredor extends Thread{

	private boolean esperandoTurno;
	private Testigo testigo;
	private int idCorredor;
	public int getIdCorredor(){return idCorredor;}
	private Random rng = new Random();
	
	public Corredor(Testigo testigo, int idCorredor){
		this.testigo = testigo;
		this.idCorredor = idCorredor;
		this.esperandoTurno = true;
	}
	
	/**
	 * Si el corredor está esperando turno (aún no ha salido a correr), intenta tomar el testigo.
	 * Si lo consigue (ie, es su turno), anuncia que entra a correr.
	 * Corre durante 0-2 segundos.
	 * Anuncia que ha dejado de correr.
	 * Deja de esperar turno, pues ya ha corrido.
	 */
	public void run(){
		while(esperandoTurno){
			if (testigo.pedirTurno(idCorredor)){
				System.out.println("Corredor " +idCorredor +" empieza a correr");
				try {
					//Corremos entre 0-2 segundos
					Thread.sleep(rng.nextInt(2));
					System.out.println("Corredor " +idCorredor +" termina de correr.");
					esperandoTurno = false;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}//run
}
