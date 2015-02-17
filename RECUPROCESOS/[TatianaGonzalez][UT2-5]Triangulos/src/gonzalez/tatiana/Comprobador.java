package gonzalez.tatiana;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Comprobador extends Thread{
	
	private Recipiente recipiente;
	private ArrayList<Integer> datos = new ArrayList<>();
	public Comprobador(Recipiente recipiente) {
		this.recipiente = recipiente;
	}

	public void run(){
		while(datos.size()<3){
			String lectura = recipiente.quitar();
			if (!lectura.equals(null)){
				datos.add(Integer.parseInt(lectura));
			}
		}
		for (int i:datos) System.out.println(i);
		if (comprobar()) recipiente.poner("SÍ");
		else recipiente.poner("NO");
	}

	public boolean comprobar(){
		if(mayor(datos)<=sumaMenores(datos)) return true;
		else return false;
	}
	
	public int mayor(ArrayList<Integer> datos){
		return Math.max(datos.get(0), Math.max(datos.get(1), datos.get(2)));
	} 
	
	public int sumaMenores(ArrayList<Integer> datos){
		datos.remove((Object) mayor(datos));
		return datos.get(0)+datos.get(1);
	}
	
}
