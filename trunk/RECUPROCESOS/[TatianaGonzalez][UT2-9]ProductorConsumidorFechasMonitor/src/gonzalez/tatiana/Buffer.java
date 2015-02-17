package gonzalez.tatiana;

import java.util.Date;
import java.util.LinkedList;

public class Buffer {
	private int capacidadMaxima;
	private LinkedList<Date> almacen;
	public int getTamanhoAlmacen(){
		return almacen.size();
	}
	public Buffer(int capacidadMaxima){
		this.capacidadMaxima = capacidadMaxima;
		this.almacen = new LinkedList<Date>(); 
	}
	
	synchronized public boolean pon(Date fecha){
		if (almacen.size()<capacidadMaxima){
			almacen.add(fecha);
			System.out.println("Tamaño del almacén: " +almacen.size());
			return true;
		}else{
			return false;
		}
	}
	synchronized public boolean quita(){
		if(almacen.size()==0){
			return false;
		}else{
			Date d = almacen.remove();
			System.out.println("Retirada " +d +".  Tamaño del almacén: " +almacen.size());
			return true;
		}
	}
}
