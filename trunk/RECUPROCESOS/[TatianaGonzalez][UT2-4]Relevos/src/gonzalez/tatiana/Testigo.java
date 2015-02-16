package gonzalez.tatiana;

public class Testigo{

	private int corredorSiguiente = 0;
	/**
	 * Incrementa el valor de corredor siguiente
	 */
	private void actualizarTurno(){corredorSiguiente++;}
	/**
	 * Recibe el identificador de un corredor; si es su turno le cede el testigo (devolviendo true) y actualiza el turno con el corredor siguiente. .
	 * @param idCorredor Identificador del corredor que intenta tomar el testigo
	 * @return true si el corredor que intenta tomar el testigo es el siguiente según el contador que lleva el testigo, false en caso contrario
	 */
	synchronized public boolean pedirTurno(int idCorredor){
		if(idCorredor==corredorSiguiente){
			actualizarTurno();
			return true;
		}else{
			return false;
		}
		
	}

}