package islasf.psp;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * Definir la interfaz remota. Cuando se crea una interfaz remota:
 *
 *   1.- La interfaz debe ser pública.
 *   2.- Debe heredar de la interfaz java.rmi.Remote, para indicar que puede llamarse desde cualquier 
 *       máquina virtual Java.
 *   3.- Cada método remoto debe lanzar la excepción java.rmi.RemoteException en su cláusula throws, 
 *       además de las excepciones que pueda manejar.
 *
 */

public interface RMICalcInterface extends java.rmi.Remote {
	public int suma(int a, int b) throws RemoteException;

	public int resta(int a, int b) throws RemoteException;

	public int multip(int a, int b) throws RemoteException;

	public int div(int a, int b) throws RemoteException;
}
