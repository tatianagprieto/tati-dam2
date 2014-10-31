package vk.tati;

/**
@author Tatiana Gonz�lez Prieto
*/

public class HiloContador implements Runnable{
	//Como no heredamos el atributo name de Thread, definimos uno y sus get y set
	//Es necesario porque nos han pedido controlar qu� hilo va imprimiendo
	//Hay otra forma m�s elegante de hacerlo, pero no lo sab�a cuando sub� esta versi�n
	//Subo �sta comentada; la siguiente revisi�n ser� ya la definitiva
//	private String name;
//	public void setName(String n){name = n;}
//	public String getName(){return name;}
//	
//	//Definimos el constructor, por par�metro se pasar� el nombre
//	public HiloContador(String n){name = n;}
	
	
	
	//Id�ntico al run() del ejercicio PSP_UT2_DosHilos_Thread
	public void run(){
		String name = Thread.currentThread().getName();
		System.out.println("Comienza la ejecuci�n de " +name);
		for (int i=2; i<201; i+=2){System.out.println(name +" imprimiendo " +i);}
		System.out.println("Termina la ejecuci�n de " +name);
	}
}
