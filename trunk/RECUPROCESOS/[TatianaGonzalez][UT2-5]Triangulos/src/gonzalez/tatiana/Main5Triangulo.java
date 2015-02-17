package gonzalez.tatiana;

import java.util.ArrayList;
import java.util.Random;

public class Main5Triangulo extends Thread{

	public static void main(String[] args) {

		Recipiente recipiente = new Recipiente();
		Comprobador comprobador = new Comprobador(recipiente);
		ArrayList<String>PARAMETROS = new ArrayList<String>();
		PARAMETROS.add("2");
		PARAMETROS.add("3");
		PARAMETROS.add("4");
		
		comprobador.start();
		
		while (PARAMETROS.size()>0){
			if(!recipiente.isLleno()){
				recipiente.poner(PARAMETROS.get(0));
				PARAMETROS.remove(0);
			}
		}
		
		try {
			comprobador.join();
			System.out.println(recipiente.getContenido() +" se forma triángulo");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run(){

	}

}
