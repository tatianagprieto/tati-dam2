package vk.tati;

public class TresHilosMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread hilo1 = new Thread("Hilo 1"){
			public void run(){
				System.out.println("Soy " +getName() +" y sumo los pares del 1 al 1000.");
				int suma = 0;
				for (int i =2; i<1001; i+=2){suma += i;}
				System.out.println("Y el resultado de " +getName() +" es: "+suma);
				System.out.println();
			}//end run
		};//.start();
		
		Thread hilo2 = new Thread("Hilo 2"){
			public void run(){
				System.out.println("Soy " +getName() +" y sumo los impares del 1 al 1000.");
				int suma = 0;
				for (int i =1; i<1001; i+=2){suma += i;}
				System.out.println("Y el resultado de " +getName() +" es: "+suma);
				System.out.println();				
			}//end run()
		};//.start();
		
		Thread hilo3 = new Thread("Hilo 3"){
			public void run(){
				System.out.println("Soy " +getName() +" y sumo los números que acaban en 2 y 3 del 1 al 1000.");
				int suma = 0;
				for (int i =1; i<1001; i+=2){
					if (i%10==2 || i%10==3) {suma += i;}
					}
				System.out.println("Y el resultado de " +getName() +" es: "+suma);
				System.out.println();
			}
		};//.start();
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		System.out.println("Soy la última instrucción del hilo principal");
	}//end main

}
