package vk.tati;

public class Hilo2 extends Thread{

	public void run(){
		System.out.println("Hilo 2 arrancando");
		for(int i=1; i<=CondicionCarrera1Main.cont.NUMVECES; i++){
			System.out.println("2." +i +"   -1");
			try{sleep(10);}catch(InterruptedException ie){}
			CondicionCarrera1Main.cont.decrementa();
		}
	}
}