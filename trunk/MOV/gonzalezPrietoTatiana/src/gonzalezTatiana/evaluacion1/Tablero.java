package gonzalezTatiana.evaluacion1;

import java.awt.font.NumericShaper;

public class Tablero {
	private Casilla casilla[] = new Casilla[9];
	private Casilla casillaSeleccionada; 
	private int numeroCasillasMarcadas = 0;
	
	public int getNumeroCasillasMarcadas(){
		return numeroCasillasMarcadas;
	}
	public void incrementarNumeroCasillasMarcadas(){numeroCasillasMarcadas++;}
	public Casilla getCasilla(int i){
		if (i>=0 && i<9) return casilla[i];
		else return null;
	}
	public Casilla getCasillaSeleccionada() {
		return casillaSeleccionada;
	}


	public void setCasillaSeleccionada(Casilla casillaSeleccionada) {
		this.casillaSeleccionada = casillaSeleccionada;
	}


	public Tablero(){
		for (int i=0; i<casilla.length; i++){
			casilla[i] = new Casilla();
		}
		
		casilla[0].setPosicion(PosicionCasilla.TL);
		casilla[1].setPosicion(PosicionCasilla.TC);
		casilla[2].setPosicion(PosicionCasilla.TR);
		casilla[3].setPosicion(PosicionCasilla.ML);
		casilla[4].setPosicion(PosicionCasilla.MC);
		casilla[5].setPosicion(PosicionCasilla.MR);
		casilla[6].setPosicion(PosicionCasilla.BL);
		casilla[7].setPosicion(PosicionCasilla.BC);
		casilla[8].setPosicion(PosicionCasilla.BR);
		
	}
	
	public boolean bloquearTablero(){
		if (hayTresEnRaya()) return true;
		else if (numeroCasillasMarcadas==9) return true;
		else return false;
	}
	
	public boolean hayTresEnRaya(){
		for (Casilla c1:this.casilla){
			for (Casilla c2:this.casilla){
				if (casillaSeleccionada.tresEnRaya(c1, c2)) return true;
			}
		}
		return false;
	}

	
}
