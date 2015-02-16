package gonzalez.tatiana;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Parking parking = new Parking(3, 5);
		ArrayList<Thread> coches = new ArrayList<Thread>();
		//Creamos tantos hilos como coches
		for (int i=1; i<=5; i++){
			coches.add(new Thread( new Coche(parking.getBarrera()),"Coche" +i));
		}
		
		System.out.println("Bienvenidos. Hay " +parking.getPlazas() +" plazas disponibles.");
		
		//arrancamos los hilos
		for (int i=1; i<=5; i++){coches.get(i-1).start();}
}
}
