package gonzalez.tatiana;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

public class AtenderUsuario implements Runnable {
	private Socket socketUsuario;
	private String usuarioAtendido;
	public String getUsuarioAtendido(){return this.usuarioAtendido;}
	public AtenderUsuario(String usuarioAtendido, Socket socketUsuario){
		this.usuarioAtendido = usuarioAtendido;
		this.socketUsuario = socketUsuario;
	}
	
	public void run(){
		//Si existe fichero asociado con el usuario,mostramos sus mensajes
		//Si no, registramos el usuario
		File mensajesUsuario = new File(usuarioAtendido+".user");
		UsuarioBuzon usuario;
		if (mensajesUsuario.exists()){
			try{
			DataInputStream dis = new DataInputStream(new FileInputStream(mensajesUsuario));
			
			} catch(FileNotFoundException e){
				System.out.println("Esto no debería haber pasado pero...");
			}
		}else{
			try {
				mensajesUsuario.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//fin if
		
	}//run
}//AtenderUsuario
