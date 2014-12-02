package gonzalez.tatiana;

public class ArrayNumeros {
	//Atributos
	private final int TAMANHO_BUFFER;
	private int[] arrayNumeros;
	private int numeroElementos = 0; //al crear el array, a�n no habr� elementos producidos
	private int indiceLeidoRestar =-1; //a�n no hemos leido nada
	private int indiceLeidoSumar = -1; //�dem
	
	//Accesores y modificadores
	public int getTamanhoBuffer(){return TAMANHO_BUFFER;}
	public int getNumeroElementos(){return numeroElementos;}
	public int getIndiceLeidoRestar(){return indiceLeidoRestar;}
	public int getIndiceLeidoSumar(){return indiceLeidoSumar;}
	public void incrementarIndiceLeidoRestar(){++indiceLeidoRestar;}
	public void incrementarIndiceLeidoSumar(){++indiceLeidoSumar;}

	//Constructor
	public ArrayNumeros(int tamanho){
		this.TAMANHO_BUFFER = tamanho;
		arrayNumeros = new int[TAMANHO_BUFFER];
	}//fin constructor

	/**
	 * Coloca el entero pasado como par�metro en la siguiente posici�n libre, que controlamos a trav�s del atributo numeroElementos
	 * @param elemento
	 * @throws InterruptedException
	 */
	public synchronized void ponerElemento(int elemento) throws InterruptedException{
		//Antes de introducir un elemento en la posici�n que toque (cuyo �ndice coincide con el n�mero de elementos ya colocados)
		//esperamos a que Restar y Sumar hayan le�do el elemento en el �ndice anterior
		while ((indiceLeidoRestar!=numeroElementos-1)&&(indiceLeidoSumar!=numeroElementos-1)){
			wait();
		}
		//Colocamos el elemento, actualizamos la informaci�n y despertamos al resto de hilos
		arrayNumeros[numeroElementos] = elemento;
		++numeroElementos;
		notifyAll();
	} 
	
	/**
	 * Devuelve el entero contenido en la posici�n pasada como par�metro.
	 * Para ello, espera a que efectivamente haya ya un entero en dicha posici�n.
	 * Se libera el cerrojo al final.
	 * @param i
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized int leerElmentoEnIndice(int i) throws InterruptedException{
		//Esperamos a que ya se haya colocado un elemento en en �ndice que queremos leer
		while(numeroElementos<=i){
			wait();
		}
		//Devolvemos el contenido de la posici�n i, avisamos al resto
		notifyAll();
		return arrayNumeros[i];
	}
	
	/**
	 * Convertimos el array en un String, mostrando los elementos entre corchetes y separados por espacios en blanco.
	 */
	public String toString(){
		String cadena = "[ ";
		for (int i = 0; i<TAMANHO_BUFFER; i++){
			cadena += arrayNumeros[i];
			cadena += " ";
		}
		return cadena +" ]";
	}
	
}//fin clase Array Numeros
