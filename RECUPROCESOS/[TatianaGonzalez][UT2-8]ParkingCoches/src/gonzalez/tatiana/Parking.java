package gonzalez.tatiana;

import java.util.Random;

/**
 * 
 * @author tatiana
 *
 */
public class Parking {
	private int plazas;
	private int coches;
	private Barrera barrera;
	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public int getCoches() {
		return coches;
	}

	public void setCoches(int coches) {
		this.coches = coches;
	}

	public Barrera getBarrera(){
		return this.barrera;
	}
	//Constructor
	/**
	 * 
	 * @param plazas
	 * @param coches
	 *
	 */
	public Parking(int plazas, int coches) {
		this.plazas = plazas;
		this.coches = coches;
		this.barrera = new Barrera(plazas);
	}		
	

	


}//fin clase Parking
