package vk.tati;

public class Hilo1 extends Thread{

	public void run(){
		System.out.println("Hilo 1 arrancando");
		for(int i=1; i<=CondicionCarrera1Main.cont.NUMVECES; i++){
			System.out.println("1." +i +"   +2");
			try{sleep(10);}catch(InterruptedException ie){}
			CondicionCarrera1Main.cont.incrementa();
			CondicionCarrera1Main.cont.incrementa();
		}
	}
}
