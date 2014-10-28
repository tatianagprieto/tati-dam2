package vk.tati;

public class HiloContador implements Runnable{
//	
	private String name;
	public void setName(String n){name = n;}
	public String getName(){return name;}
	
	public HiloContador(String n){name = n;}
	
	public void run(){
		System.out.println("Comienza la ejecución de " +name);
		for (int i=2; i<201; i+=2){System.out.println(name +" imprimiendo " +i);}
		System.out.println("Termina la ejecución de " +name);
	}
}
