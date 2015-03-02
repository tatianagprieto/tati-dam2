package gonzalez.tatiana;

import java.io.Serializable;

public class Mensaje implements Serializable{
	private int tipo;
	private String texto;
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	@Override
	public String toString() {
		return tipo + " - " + texto;
	}
	public Mensaje(int tipo, String texto) {
		this.tipo = tipo;
		this.texto = texto;
	}
	
}
