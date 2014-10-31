package vk.tati;

/**
@author Tatiana González Prieto
*/

public class HiloContador implements Runnable{
	//Como no heredamos el atributo name de Thread, definimos uno y sus get y set
	//Es necesario porque nos han pedido controlar qué hilo va imprimiendo
	//Hay otra forma más elegante de hacerlo, pero no lo sabía cuando subí esta versión
	//Subo ésta comentada; la siguiente revisión será ya la definitiva
//	private String name;
//	public void setName(String n){name = n;}
//	public String getName(){return name;}
//	
//	//Definimos el constructor, por parámetro se pasará el nombre
//	public HiloContador(String n){name = n;}
	
	
	
	//Idéntico al run() del ejercicio PSP_UT2_DosHilos_Thread
	public void run(){
		String name = Thread.currentThread().getName();
		System.out.println("Comienza la ejecución de " +name);
		for (int i=2; i<201; i+=2){System.out.println(name +" imprimiendo " +i);}
		System.out.println("Termina la ejecución de " +name);
	}
}
