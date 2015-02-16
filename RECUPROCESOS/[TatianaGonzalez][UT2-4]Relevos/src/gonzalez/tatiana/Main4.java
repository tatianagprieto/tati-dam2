package gonzalez.tatiana;

import java.util.ArrayList;

/**Escribe un clase llamada Relevos que simule un carrera de relevos de la siguiente forma:
�  Debe crear 4 Hilos, cada uno tendr� un id (es decir, 0,1,2,� 3) que quedar�n a la espera de recibir alguna
se�al para comenzar a correr. Una vez creados los hilos se indicar� que comience la carrera, con lo que uno
de los hilos deber� comenzar a correr. Mostrar� un mensaje por pantalla diciendo que empieza a correr y a
continuaci�n se dormir� un tiempo aleatorio entre 0 y 1 segundo.
�  Cuando un hilo termina de correr, pone alg�n mensaje en pantalla y espera un par de segundos, pasando el
testigo a otro de los hilos para que comience a correr, y termina su ejecuci�n
�  Cuando el �ltimo hilo termina de correr, el �Padre� mostrar� un mensaje indicando que todos los hijos han
terminado
Pista: Crear clase Testigo para tener un objeto que ser� el encargado de la sincronizaci�n de los hilos y
comprobar si es el turno del corredor que le toque. Cada hilo (Clase Corredor) recibir� el testigo y tratar� de
echarse a correr si puede coger el testigo.

*/

public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int NUMERO_CORREDORES = 4;
			
		Testigo testigo = new Testigo();
		ArrayList<Thread> corredor = new ArrayList<Thread>();
		
		//Creamos los corredores
		for (int i=0; i<NUMERO_CORREDORES; i++){
			corredor.add(new Corredor(testigo, i));
		}
		//Comienza la carrera
		System.out.println("¡Comienza la carrera!");
		//Arrancamos los hilos de los corredores
		for (int i=0; i<NUMERO_CORREDORES; i++){
			System.out.println("Listo corredor " +i);
			corredor.get(i).start();
		}
		
		//Esperamos a todos para anunciar el final
		for (int i=0; i<NUMERO_CORREDORES; i++){
			try {
				corredor.get(i).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		System.out.println("Carrera terminada");
	}

}
