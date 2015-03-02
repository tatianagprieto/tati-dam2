package gonzalez.tatiana;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class UsuarioBuzon extends UnicastRemoteObject implements Serializable, MetodosRemotos{
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
	
	public UsuarioBuzon(String nombre) throws RemoteException{
		super();
		this.nombre = nombre;
		this.mensajesPendientes = new ArrayList<Mensaje>();
	}
	
	public String toString(){
		return this.nombre;
	}
	@Override
	public ArrayList<String> cargarUsuarios() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UsuarioBuzon getUsuario() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void enviarMensaje(UsuarioBuzon destinatario) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
}
