package gonzalez.tatiana;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ServidorBuzon implements MetodosBuzon{
	
	private static ArrayList<String> usuariosRegistrados;
	
	
	public static void main(String args[]){
		ServidorBuzon s = new ServidorBuzon();
		s.comprobarDirectorioDatos();
		s.cargarListaUsuarios();
		s.mostrarMenu();
	}

	@Override
	public void comprobarDirectorioDatos(){
		File directorio = new File("./datos");
		if (!directorio.exists() || !directorio.isDirectory()){
			directorio.mkdir();
		}
	}
	
	@Override
	public void cargarListaUsuarios() {
			File directorioActual = new File("./datos");
			for (String f: directorioActual.list()){
				System.out.println(f.replace(".data", ""));
				usuariosRegistrados.add(f);
			}
	}

	@Override
	public ArrayList<Mensaje> cargarArchivoMensajes(Usuario usuario) throws IOException, ClassNotFoundException {
		File archivo = new File("./datos" +usuario.getNombre() +".data");
		if (!archivo.exists()){
			archivo.createNewFile();
			return new ArrayList<Mensaje>();
		}else{
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream(archivo));
			return (ArrayList<Mensaje>) oos.readObject();
		}
	}

	@Override
	public void guardarArchivoMensajes(Usuario usuario) throws IOException {
		// TODO Auto-generated method stub
		File archivo = new File("./datos" +usuario.getNombre() +".data");
		if (!archivo.exists()){
			archivo.createNewFile();
		}
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
		oos.writeObject(usuario.getMensajesPendientes());
	}

	@Override
	public String enviarMensaje(Mensaje mensaje) {
		// TODO Auto-generated method stub
		File archivoDestinatario = new File("./datos" +mensaje.getDestinatario().getNombre() +".data");
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoDestinatario));
				ArrayList<Mensaje> colaMensajes = (ArrayList<Mensaje>) ois.readObject();
				colaMensajes.add(mensaje);
				ois.close();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoDestinatario));
				oos.writeObject(colaMensajes);
				oos.close();
				return "Mensaje enviado con éxito";
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				return "Destinatario desconocido";
			} catch (IOException e) {
				return "Error de acceso al sistema";
			} catch (ClassNotFoundException e) {
				return "Error que no debería haber ocurrido :(";
			}
	}

	@Override
	public void mostrarMenu() {
		// TODO Auto-generated method stub
		System.out.println("Elija la operación que quiere realizar: ");
		System.out.println("1 - Refrescar mensajes");
		System.out.println("2 - Mostrar usuarios");
		System.out.println("3 - Enviar mensaje");
	}
	
	

	
}//fin clase
