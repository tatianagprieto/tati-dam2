package vk.tati;

public class TiradaDadosMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tirada1, tirada2;
		Dado dado1 = new Dado("Dado 1");
		Dado dado2 = new Dado("Dado 2");

		dado1.start();
		dado2.start();
	
		try{
			dado1.join();
			dado2.join();
		}catch(InterruptedException ie){}
		
		tirada1 = dado1.getResultado();
		tirada2 = dado2.getResultado();
		
		System.out.println("Tirada 1: " +tirada1 + " - Tirada 2: " +tirada2);
		if (tirada1>tirada2){System.out.println("Gana Dado 1");}
		else if (tirada2>tirada1){System.out.println("Gana Dado 2");}
		else{System.out.println("Empate.");}
		
	}	

}
