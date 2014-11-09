package vk.tati;


import java.util.ArrayList;

/**
 * 
 * @author tatiana
 *
 *Implementa una clase Contador, que gestiona un  único  atributo  de  tipo  entero  (valor),  al  que  se  puede asignar un valor o, simplemente, consultarlo.

A  continuación  implementa  la  clase  HiloContador,  que recibe en el constructor un objeto de la clase  Contador, y que, al ejecutarse realiza tres veces lo siguiente:
lee el valor que  almacena  el  objeto  contador,  
descansa  por  unos milisegundos y le suma uno. 
Por último, muestra el valor del contador al finalizar el proceso completo.
Implementa un programa que instancie un objeto de la clase Contador y cree cinco hilos de tipo HiloContador.
 */

public class SincroHilosMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contador c = new Contador();
		ArrayList<HiloContador> hilo = new ArrayList<HiloContador>();

		//No pide hacer nada con los HiloContador inStanciados, pero pruebo esto.
		for (int i=0; i<5; i++) {
			hilo.add(new HiloContador(c, "Hilo "+i));
			hilo.get(i).start();
	
		}
	}

	
}
