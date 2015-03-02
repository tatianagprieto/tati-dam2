package gonzalez.tatiana;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private ArrayList<Mensaje> mensajesPendientes;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Mensaje> getMensajesPendientes() {
		return mensajesPendientes;
	}
	public void setMensajesPendientes(ArrayList<Mensaje> mensajesPendientes) {
		this.mensajesPendientes = mensajesPendientes;
	}
	
	public Usuario(String nombre){
		this.nombre = nombre;
		this.mensajesPendientes = new ArrayList<Mensaje>();
	}
	
}
