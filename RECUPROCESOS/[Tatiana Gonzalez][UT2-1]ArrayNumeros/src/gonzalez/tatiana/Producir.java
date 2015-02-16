package gonzalez.tatiana;

import java.util.Random;

public class Producir implements Runnable{

	private Random rng = new Random();
	private ArrayNumeros array;
	
	//Constuctor, pasamos los datos compartidos como par�metro
	public Producir(ArrayNumeros array){this.array = array;}
	
	/**
	 * Generamos un entero aleatorio entre 0 y 9, lo colocamos en el array.
	 * @param indice Indica la posici�n en la que se almacenar� el entero generadp.
	 * @return El entero colocado en la posici�n indicada por el �ndice.
	 * @throws InterruptedException
	 */
	public int colocarElemento(int indice) throws InterruptedException{
		int elemento = rng.nextInt(10);
		array.ponerElemento(elemento);
		Thread.sleep(400); //descansamos
		return elemento;
	}
	
	public void run(){
		int elementoColocado;
		for(int i=0; i<array.getTamanhoBuffer(); i++){
			try{
				elementoColocado = colocarElemento(i);
				System.out.println("Crea el n�mero: " +elementoColocado);
			}catch(InterruptedException e){}
		}// end for
	}//end run

}//end Producir
