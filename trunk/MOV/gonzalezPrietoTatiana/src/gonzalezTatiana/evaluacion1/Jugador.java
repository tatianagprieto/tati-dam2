package gonzalezTatiana.evaluacion1;

public class Jugador {
	private String nombre;
	private EstadoCasilla estadoAsociado;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public EstadoCasilla getEstadoAsociado() {
		return estadoAsociado;
	}
	public void setEstadoAsociado(EstadoCasilla estadoAsociado) {
		this.estadoAsociado = estadoAsociado;
	}
	
	public Jugador(String nombre, EstadoCasilla estadoAsociado){
		this.nombre = nombre;
		this.estadoAsociado = estadoAsociado;
	}

}
