package gonzalezTatiana.evaluacion1;

public class Partida {
	private Jugador jugador1, jugador2, turnoActual, ganador;
	
	Casilla[][] tablero = {{new Casilla(EstadoCasilla.VACIA, PosicionCasilla.TL), new Casilla(EstadoCasilla.VACIA, PosicionCasilla.TC),new Casilla(EstadoCasilla.VACIA, PosicionCasilla.TR)},
			{new Casilla(EstadoCasilla.VACIA, PosicionCasilla.ML), new Casilla(EstadoCasilla.VACIA, PosicionCasilla.MC),new Casilla(EstadoCasilla.VACIA, PosicionCasilla.MR)},
			{new Casilla(EstadoCasilla.VACIA, PosicionCasilla.BL), new Casilla(EstadoCasilla.VACIA, PosicionCasilla.BC),new Casilla(EstadoCasilla.VACIA, PosicionCasilla.BR)}};
	
	public Partida(Jugador jugador1, Jugador jugador2){
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.turnoActual = jugador1;
		this.ganador = null;
	}
	
	
}
