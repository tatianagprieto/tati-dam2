package gonzalez.tatiana;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MetodosRemotos extends Remote{
	public ArrayList<String> cargarUsuarios() throws RemoteException;
	public UsuarioBuzon getUsuario() throws RemoteException;
	public void enviarMensaje(UsuarioBuzon destinatario) throws RemoteException;
}
