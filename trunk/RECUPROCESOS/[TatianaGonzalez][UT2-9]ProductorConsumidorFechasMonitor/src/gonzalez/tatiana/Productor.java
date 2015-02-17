package gonzalez.tatiana;

import java.util.Date;

public class Productor implements Runnable{

	Buffer buffer;
	
	public Productor(Buffer buffer){
		this.buffer = buffer;
	}
	
	public void run(){
		int contador = 0;
		while(contador<100){
			if (buffer.pon(new Date())) contador++;
		}
	}
}//clase
