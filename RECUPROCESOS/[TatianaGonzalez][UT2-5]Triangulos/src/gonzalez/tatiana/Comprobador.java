package gonzalez.tatiana;

import java.util.concurrent.Semaphore;

public class Comprobador extends Thread{
	
	private Recipiente recipiente;

	public Comprobador(Recipiente recipiente) {
		this.recipiente = recipiente;
	}

	private int[] datos = new int[3];
	
	public void run(){
		for(int i = 0; i<datos.length; i++){
			while (!recipiente.isLleno()){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			datos[i] = Integer.parseInt(recipiente.quitar());
			notify();
//			try {
//				recipiente.semaforoLector.acquire();
//				recipiente.semaforoUso.acquire();
//				datos[i] = Integer.parseInt(recipiente.quitar());
//				recipiente.semaforoLector.release();
//				recipiente.semaforoUso.release();
//			} catch (NumberFormatException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		System.out.println(datos[0] +" " +datos[1] +" " +datos[2] +" " );
	}
	
}
