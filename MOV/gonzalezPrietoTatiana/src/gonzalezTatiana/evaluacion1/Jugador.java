package gonzalezTatiana.evaluacion1;

import java.io.Serializable;

import android.graphics.Color;

public class Jugador implements Serializable {
	private String nombre;
	private EstadoCasilla estadoAsociado;
	private int color;
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
	
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public Jugador(String nombre, int color){
		this.nombre = nombre;
		//this.estadoAsociado = estadoAsociado;
		this.color = color;
	}

}
