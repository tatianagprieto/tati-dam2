package gonzalezTatiana.evaluacion1;

public class Casilla {
	private EstadoCasilla estado;
	private PosicionCasilla posicion;
	
	public Casilla(EstadoCasilla estado, PosicionCasilla posicion){
		this.estado = estado;
		this.posicion = posicion;
	}

	public boolean tresEnRaya(Casilla casilla1, Casilla casilla2){
		if (this.formanRaya(casilla1, casilla2) && this.mismoEstado(casilla1, casilla2)) return true;
		else return false;
	}
	
	public boolean formanRaya(Casilla casilla1, Casilla casilla2){
		if (this.mismaFila(casilla1, casilla2) || this.mismaColumna(casilla1, casilla2) || this.mismaDiagonal(casilla1, casilla2)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean mismoEstado(Casilla casilla1, Casilla casilla2){
		if (this.estado == casilla1.estado && this.estado == casilla2.estado) return true;
		else return false;
	}
	
	public boolean mismaFila(Casilla casilla1, Casilla casilla2){
		if ( this.posicion.getFila() ==casilla1.posicion .getFila() && this.posicion.getFila() == casilla2.posicion.getFila() ){
			return true;
		}
		else{
			return false;
		}
}//mismaFila
	public boolean mismaColumna(Casilla casilla1, Casilla casilla2){
		if ( this.posicion.getColumna() ==casilla1.posicion .getColumna() && this.posicion.getColumna() == casilla2.posicion.getColumna() ){
			return true;
		}
		else{
			return false;
		}
}//mismaFila
	public boolean mismaDiagonal(Casilla casilla1, Casilla casilla2){
		if( ( this.posicion.sumaPosiciones() == 0 && casilla1.posicion.sumaPosiciones() == 0 && casilla2.posicion.sumaPosiciones() == 0)
		|| (this.posicion .estaEnDiagonalSecundaria() && casilla1.posicion.estaEnDiagonalSecundaria() && casilla2.posicion.estaEnDiagonalSecundaria()))
		{
			return true;
		}
		else{
			return false;
		}
}//mismaFila

}//end Casilla
