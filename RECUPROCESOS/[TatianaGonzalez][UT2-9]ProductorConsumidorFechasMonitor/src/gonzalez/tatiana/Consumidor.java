package gonzalez.tatiana;

public class Consumidor implements Runnable{
	Buffer buffer;
	
	public Consumidor(Buffer buffer){
		this.buffer = buffer;
	}
	
	public void run(){
		int contador = 0;
		while(contador<100){
			if(buffer.quita()) contador++;
		}
	}
}
