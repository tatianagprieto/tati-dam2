package gonzalez.tatiana;

import java.util.ArrayList;

public class Main8 {
	
	public static void main(String[] args) {
		int NUMERO_PLAZAS = 4;
		int NUMERO_COCHES = 7;
		
		Parking parking = new Parking(NUMERO_PLAZAS, NUMERO_COCHES);
		ArrayList<Coche> coches = new ArrayList<Coche>();
		//Creamos tantos hilos como coches
		for (int i=1; i<=NUMERO_COCHES; i++){
			coches.add(new Coche(i, parking.getBarrera()));
		}
		
		System.out.println("Bienvenidos. Hay " +parking.getPlazas() +" plazas disponibles.");
		System.out.println();
		
		//arrancamos los hilos
		for (int i=1; i<=NUMERO_COCHES; i++){coches.get(i-1).start();}
}
}
