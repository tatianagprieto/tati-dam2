package vk.tati;

import java.io.IOException;

public class HiloContador extends Thread{
	private Contador cont;
	public HiloContador(Contador cont, String n){
		super(n);
		this.cont = cont;}
	
/**
 * al ejecutarse realiza tres veces lo siguiente:
lee el valor que  almacena  el  objeto  contador,  
descansa  por  unos milisegundos y le suma uno. 
 */
	
	public void run() {
		int n;
		System.out.println("Introduce un valor: ");
		try {
			n = System.in.read();
			cont.setValor(n);
			sleep(1000);
			cont.setValor(++n);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("["+getName()+"]: " +" El valor almacenado es: " +cont.getValor());
	}
		
}
