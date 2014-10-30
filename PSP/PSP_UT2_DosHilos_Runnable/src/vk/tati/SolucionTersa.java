package vk.tati;

public class SolucionTersa {

	public static void main(String[] args){
		
		new Thread("Hilo 1"){
			public void run(){escribirCosas(getName());}
		}.start();
	
		new Thread("Hilo 2"){
			public void run(){escribirCosas(getName());}
		}.start();		
	}
	
	public static void escribirCosas(String name){
		System.out.println("Comienza la ejecución de " +name);
		for (int i=2; i<201; i+=2){System.out.println(name +" imprimiendo " +i);}
		System.out.println("Termina la ejecución de " +name);
	}
}
