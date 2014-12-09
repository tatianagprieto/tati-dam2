package gonzalezTatiana.evaluacion1;

import android.widget.Button;

public class Casilla {
	private EstadoCasilla estado;
	private PosicionCasilla posicion;
	private Button botonAsociado;
	
	//Constructores
	public Casilla(){
		estado = EstadoCasilla.VACIA;
	}
	public Casilla(EstadoCasilla estado, PosicionCasilla posicion){
		this.estado = estado;
		this.posicion = posicion;
	}
	public Casilla(PosicionCasilla posicion){
		this.estado = EstadoCasilla.VACIA;
		this.posicion = posicion;
	}
	//Getters y setters
	public EstadoCasilla getEstado() {
		return estado;
	}
	public void setEstado(EstadoCasilla estado) {
		this.estado = estado;
	}
	public PosicionCasilla getPosicion() {
		return posicion;
	}
	public void setPosicion(PosicionCasilla posicion) {
		this.posicion = posicion;
	}
	public Button getBotonAsociado() {
		return botonAsociado;
	}
	public void setBotonAsociado(Button botonAsociado) {
		this.botonAsociado = botonAsociado;
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
		if ( this.posicion.getFila() ==casilla1.posicion .getFila() && this.posicion.getFila() == casilla2.posicion.getFila() 
			&& this!=casilla1 && this!=casilla2 && casilla1!=casilla2	){
			return true;
		}
		else{
			return false;
		}
}//mismaFila
	public boolean mismaColumna(Casilla casilla1, Casilla casilla2){
		if ( this.posicion.getColumna() ==casilla1.posicion .getColumna() && this.posicion.getColumna() == casilla2.posicion.getColumna() 
				&& this!=casilla1 && this!=casilla2 && casilla1!=casilla2	){
			return true;
		}
		else{
			return false;
		}
}//mismaFila
	public boolean mismaDiagonal(Casilla casilla1, Casilla casilla2){
		if( this!=casilla1 && this!=casilla2 && casilla1!=casilla2	&&
				(( this.posicion.sumaPosiciones() == 0 && casilla1.posicion.sumaPosiciones() == 0 && casilla2.posicion.sumaPosiciones() == 0)
		|| (this.posicion .estaEnDiagonalSecundaria() && casilla1.posicion.estaEnDiagonalSecundaria() && casilla2.posicion.estaEnDiagonalSecundaria()))
		)
		{
			return true;
		}
		else{
			return false;
		}
}//mismaFila

	public boolean marcarCasilla(Jugador jugador){
		if (this.estado == EstadoCasilla.VACIA){
			this.estado = jugador.getEstadoAsociado();
			return true;
		}
		else return false;
	}
}//end Casilla
