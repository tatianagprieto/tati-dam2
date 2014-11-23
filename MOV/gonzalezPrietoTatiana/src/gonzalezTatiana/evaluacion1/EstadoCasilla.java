package gonzalezTatiana.evaluacion1;

public enum EstadoCasilla {
	VACIA (0),
	JUGADOR_1(1),
	JUGADOR_2(2);
	
	private int estado;
	
	public int getEstado(){return this.estado;}
	
	EstadoCasilla(int estado){
		this.estado = estado;
	}
}
