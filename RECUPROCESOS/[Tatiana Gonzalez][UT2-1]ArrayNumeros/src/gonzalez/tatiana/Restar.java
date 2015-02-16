package gonzalez.tatiana;

public class Restar implements Runnable{
	//Atributos
	private int resultado = 0;
	private ArrayNumeros array;
	
	//Accesor al resultado de la resta
	public int getResultado(){return resultado;}
	
	//Constructor, pasamos los datos compartidos por parámetro
	public Restar(ArrayNumeros array){this.array = array;}

	/**
	 * Se ejecuta el método sumar y se captura la excepción, aunque sin tratarla.
	 */	
	public void run(){
		try {restar();} 
		catch(InterruptedException e){}
	}//end run

	/**
	 * Para cada posición del array se lee su contenido y se resta al resultado.
	 * Se incrementa el contador de elementos leidos y se muestra el resultado.
	 * @throws InterruptedException
	 */
	public synchronized void restar() throws InterruptedException{
		for (int i = 0; i < array.getTamanhoBuffer(); i++) {
			resultado -= array.leerElmentoEnIndice(i);
			array.incrementarIndiceLeidoRestar();
			System.out.println("Restador: " +resultado);
		} 
	}
	
}//end Restar
