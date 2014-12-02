package gonzalez.tatiana;

public class UT2_ArrayNumeros_Main {

	public static void main(String[] args) {
		//Instanciamos un ArrayNumeros de tamaño 10;
		//Es el dato que compartiran los tres hilos que creamos a continuación
		ArrayNumeros array = new ArrayNumeros(10);
		
		//Definimos tres hilos
		Thread productor,sumador, restador;
		
		//Los instanciamos usando el método Thread(Runnable target, String name)
		//Vamos a necesitar consultar atributos de los objetos sumar y restar, así que referenciamos estos objetos al instanciarlos
		Sumar sumar = new Sumar(array);
		Restar restar = new Restar(array);
		//Con el objeto de tipo Producir no es necesario, lo instanciamos directamente al llamar el constructor 
		productor = new Thread(new Producir(array), "Productor");
		sumador = new Thread(sumar, "Sumador");
		restador = new Thread(restar, "Restador");
		
		//Arrancamos los tres hilos
		productor.start();
		sumador.start();
		restador.start();

		//Esperamos aque terminen antes de escribir los mensajes finales
		try{
			productor.join();
			sumador.join();
			restador.join();
		}catch(InterruptedException ie){}
		
		//Mensajes finales, se muestra el array y los resultados totales
		System.out.println("*****Fin del programa*****");
		System.out.println("Array: " +array.toString());
		System.out.println("Suma total: " +sumar.getResultado());
		System.out.println("Resta total: " +restar.getResultado());
		
	}

}
