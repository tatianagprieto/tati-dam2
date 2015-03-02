package islasf.psp;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 * 1.- El método main hace uso de las clases java.rmi.registry.Registry y 
 * java.rmi.registry.LocateRegistry para localizar el registro de objetos remotoos.
 * La llamada al método lookup() de la clase Registry devuelve el objeto stub que 
 * el cliente utilizará para invocar remotatamente a los métodos del objeto servicor
 * 
 * 2.- Para localizar el objeto remoto: dirección ip + puerto y el nombre con el que 
 * se inscribió el objeto servidor en el registro (en este caso "Calculadora")
 * 
 * 3.- Una vez obtenido el stub, el cliente invoca los métodos remotos como si sse tratase de 
 * métodos en un objeto local
 * 
 *
 */
public class RMICalcCliente {
	public static void main(String[] args) {
		RMICalcInterface calc = null;
		try {
			/**
			 * Las clases Registry y LocateRegistry permiten realizar tareas como crear un registro, 
			 * localizar un registro existente,… desde dentro del programa
			 * En este caso, en lugar del puerto 1099(el de defecto) utilizamos el 5555
			 */
			Registry registry = LocateRegistry.getRegistry("localhost", 5555);
			// Obteniendo el stub del objeto remoto…
			calc = (RMICalcInterface) registry.lookup("Calculadora");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (calc != null) {
			try {
				System.out.println("2 + 2 = " + calc.suma(2, 2));
				System.out.println("99 - 45 = " + calc.resta(99, 45));
				System.out.println("125 * 3 = " + calc.multip(125, 3));
				System.out.println("1250 / 5 = " + calc.div(1250, 5));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
}
