package islasf.psp;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 1.- Se implementa la interfaz remota RMICalcInterface 2.- Podría haberse
 * puesto como extends UnicastRemoteObject que podemos utilizar como superclase
 * para implementar objetos remotos. En este caso no se extiende y se usa método
 * estático UnicastRemoteObject.exportObject()
 * 
 */

public class RMICalcServer implements RMICalcInterface {
	public int suma(int a, int b) throws RemoteException {
		return (a + b);
	}

	public int resta(int a, int b) throws RemoteException {
		return (a - b);
	}

	public int multip(int a, int b) throws RemoteException {
		return (a * b);
	}

	public int div(int a, int b) throws RemoteException {
		return (a / b);
	}

	/**
	 * 1.- El método main, definimos el código para crear el objeto remoto que se
	 * quiere compartir y hacer el objeto remoto visible para los clientes,
	 * mediante la clase Naming y su método rebind(...). Cuando se inscribe un
	 * objeto remoto en el registro, se le debe dar un nombre único para
	 * identificarlo. En este ejemplo es “Calculadora”
	 * 
	 * 2.- Hemos puesto el método main() dentro de la misma clase por comodidad. 
	 * Podría definirse otra clase aparte que fuera la encargada de registrar el objeto remoto
	 */

	public static void main(String[] args) {
		
		/**
		 * Las clases Registry y LocateRegistry permiten realizar tareas como crear un registro, 
		 * localizar un registro existente,… desde dentro del programa
		 * En este caso, en lugar del puerto 1099(el de defecto) utilizamos el 5555
		 */
		System.out.println("Creando registro de objetos remotos…");
		Registry reg = null;
		try {
			// Con createRegistry no es necesario arrancar antes el rmiregistry 5555 &
			//reg = LocateRegistry.createRegistry(5555);
			reg = LocateRegistry.getRegistry(5555);
		} catch (Exception e) {
			System.out.println("ERROR: No se ha podido crear el registro");
			e.printStackTrace();
		}
		System.out
				.println("Creando el objeto servidor e inscribiéndolo en el registro…");
		/**
		 * Una vez arrancado el registro, el método main crea un objeto servidor y lo inscribe 
		 * en éste haciendo uso de la clase UnicastRemoteObject, que sirve para representar objetos remotos 
		 * y operar con ellos. 
		 * El método rebind() de la clase Registry permite realizar esta inscripción. 
		 * Cuando se inscribe un objeto remoto en el registro, se le debe dar un 
		 * nombre único para identificarlo. En este ejemplo es “Calculadora”
		 */
		RMICalcServer serverObject = new RMICalcServer();
		try {
			RMICalcInterface stub = (RMICalcInterface) UnicastRemoteObject.exportObject(serverObject,0);
			reg.rebind("Calculadora", stub);
			System.out.println("Servidor iniciado.");
			
		} catch (Exception e) {
			System.out
					.println("ERROR: No se ha podido inscribir el objeto servidor.");
			e.printStackTrace();
		}
	}
}
