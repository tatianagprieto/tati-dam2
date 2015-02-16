package gonzalez.tatiana;

/**
 * 
 * @author tatiana
 *
 */
public class Barrera {
	private int[] plazas;
	private int numeroPlazas;
	private int plazasLibres;
	
	public Barrera(int numeroPlazas){
		this.plazas = new int[numeroPlazas];
		this.numeroPlazas = numeroPlazas;
		this.plazasLibres = numeroPlazas;
	}
	
	/**
	 * 
	 * 
	 * 
	 * Asigna 0 a la plaza que queda libre e incrementa el contador de plazas libres
	 * @param idCoche identificador del coche que ocupaba la plaza que va a quedar libre
	 */
	synchronized public void liberarPlaza(int idCoche){
		plazas[buscarCoche(idCoche)] = 0;
		plazasLibres ++;
		notify(); //notificamos que hay una plaza disponible
	}
	/**
	 * Asigna una plaza a un coche en caso de haber alguna disponible. Almacena en ella idCoche y la marca como ocupada (descontándola en plazasLibres)
	 * @param idCoche identificador del coche que solicita entrada al garaje
	 * @return true si permite el acceso, false si lo deniega por no habler plazas libres.
	 */
	synchronized public boolean solicitarPlaza(int idCoche){
		if (plazasLibres == 0) return false;
		else{
			plazas[buscarPlazaLibre()] = idCoche;
			plazasLibres --;
			//if(plazasLibres==0) System.out.println("INFO PARKING: ****NO HAY PLAZAS LIBRES****");
			return true;
		}
	}
	/**
	 * Recorre los elementos del array plazas en busca de uno que valga cero (ie, una plaza libre)
	 * @return -1 si todas las plazas estan ocupadas, un índice de plaza libre en otro caso.
	 */
	private int buscarPlazaLibre(){
		for(int i=0; i<plazas.length; i++){
			if (plazas[i]==0) return i;
		}
		return -1;
	}
	
	public int buscarCoche(int idCoche){
		for(int i=0; i<plazas.length; i++){
			if (plazas[i]==idCoche) return i;
		}
		return -1; //esto no debería ocurrir :(
	}
	
}