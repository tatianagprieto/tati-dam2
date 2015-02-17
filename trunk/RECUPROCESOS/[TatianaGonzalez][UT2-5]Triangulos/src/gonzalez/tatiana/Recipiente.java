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

	public void poner(String s){
		this.contenido = s;
		lleno = true;
	}
	
	public String quitar(){
		String aux = contenido;
		contenido = null;
		lleno = false;
		return aux;
	}

}//clase