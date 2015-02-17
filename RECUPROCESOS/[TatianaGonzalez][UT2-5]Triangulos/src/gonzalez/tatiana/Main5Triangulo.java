package gonzalez.tatiana;

import java.util.Random;

public class Main5Triangulo extends Thread{
		int[] PARAMETROS = {2,3,4};
		Recipiente recipiente = new Recipiente();	
		
		Comprobador comprobador = new Comprobador(recipiente);
		/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] PARAMETROS = {"2","3","4"};

		//Random rng = new Random();
		new Main5Triangulo().start();
	}
	
	public void run(){

		
		for (int i=0; i<PARAMETROS.length; i++){
			while (recipiente.isLleno()){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			recipiente.poner( Integer.toString(PARAMETROS[i]) );
			notify();
//			try {
//				recipiente.semaforoUso.acquire();
//				Thread.sleep(3000);
//				recipiente.poner( Integer.toString(PARAMETROS[i]) );
//				recipiente.semaforoUso.release();
//				recipiente.semaforoLector.release();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		}
		
		comprobador.start();
	}

}
