package vk.tati;

public class HiloContador extends Thread {
	
	//Definimos el constructor que nos permite darle un nombre al hilo
	public HiloContador(String name){
		//Simplemente hay que invocar al constructor de la clase padre
		super(name);
	}
	
	//Sobreescribimos el método run de la clase Thread
	@Override 
	public void run(){
			System.out.println("Comienza la ejecución de " +getName());
			for (int i=2; i<201; i+=2){System.out.println(getName() +" imprimiendo " +i);}
			System.out.println("Termina la ejecución de " +getName());		
	}
}
