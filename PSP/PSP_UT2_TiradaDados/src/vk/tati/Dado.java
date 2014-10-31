package vk.tati;

import java.util.Random;

public class Dado extends Thread{
	int resultado;
	public int getResultado(){return resultado;}
	
	public Dado(String nombre){super(nombre);}
	
	public void run(){
		Random rg = new Random();
		resultado = rg.nextInt(6) + 1;
	}
}
