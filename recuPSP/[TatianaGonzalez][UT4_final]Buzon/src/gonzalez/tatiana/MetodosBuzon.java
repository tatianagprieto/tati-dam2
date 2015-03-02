package gonzalez.tatiana;

import java.io.IOException;
import java.util.ArrayList;

public interface MetodosBuzon {
	public void comprobarDirectorioDatos();
	
	public void cargarListaUsuarios();
	
	
	public ArrayList<Mensaje> cargarArchivoMensajes(Usuario usuario) throws IOException, ClassNotFoundException;
	public void guardarArchivoMensajes(Usuario usuario) throws IOException;
	
	public String enviarMensaje(Mensaje mensaje);
	
	public void mostrarMenu();
}
