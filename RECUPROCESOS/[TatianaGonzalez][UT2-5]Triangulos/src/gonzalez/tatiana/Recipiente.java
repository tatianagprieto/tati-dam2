package gonzalez.tatiana;

import java.util.concurrent.Semaphore;

public class Recipiente{
	private String contenido = "111";
	private boolean lleno;
	public Semaphore semaforoUso = new Semaphore(1);
	public Semaphore semaforoLector = new Semaphore(0);
	
	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public boolean isLleno() {
		return lleno;
	}

	public void setLleno(boolean lleno) {
		this.lleno = lleno;
	}

	synchronized public boolean poner(String s){
		if (lleno){
			return false;
		}else{
			this.contenido = s;
			lleno = true;
			return true;
		}
	}
	
	synchronized public String quitar(){
		if (lleno){
			String aux = contenido;
			contenido = null;
			lleno = false;
			return aux;
		}else{
			return null;
		}
	}

}//clase