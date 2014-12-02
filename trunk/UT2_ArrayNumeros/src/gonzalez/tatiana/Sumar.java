package gonzalez.tatiana;

public class Sumar implements Runnable{
	//Atributos
	private int resultado = 0;
	private ArrayNumeros array;
	
	//Accesor al resultado
	public int getResultado(){return resultado;}
	
	//Constructor, pasamos los datos compartidos por par�metro
	public Sumar(ArrayNumeros array){this.array = array;}
	
	/**
	 * Se ejecuta el m�todo sumar y se captura la excepci�n, aunque sin tratarla.
	 */
	public void run(){
		try{sumar();}
		catch(InterruptedException e){}
	}//end run

	/**
	 * Para cada posici�n del array se lee su contenido y se suma al resultado.
	 * Se incrementa el contador de elementos leidos y se muestra el resultado.
	 * @throws InterruptedException
	 */	
	public synchronized void sumar() throws InterruptedException{
		for (int i = 0; i < array.getTamanhoBuffer(); i++) {
			//leemos el elemento que toque y lo sumamos al resultado, avisamos al array de que hemos leido el elemento
			resultado += array.leerElmentoEnIndice(i);
			array.incrementarIndiceLeidoSumar();
			//Imprimimos el resultado
			System.out.println("Sumador: " +resultado);
		} 
	}//end Sumar
	
}
