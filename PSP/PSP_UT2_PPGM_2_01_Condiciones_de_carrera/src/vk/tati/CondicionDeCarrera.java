package vk.tati;

public class CondicionDeCarrera implements Runnable{
	public static final int NUMERO_SUMADO = 10000;
	public static final long NUM_VECES = 10000;

	private static long sumaN(long acumulador, int n){
		long total = acumulador;
		for (int i=0; i<n; ++i) total += 1;
		return total;
	}
	
	public void run(){
			for (int i=1; i<=NUM_VECES; ++i){
			_suma = sumaN(_suma, NUMERO_SUMADO);
		}
	}
	
	public long getSuma(){
		return _suma;	
	}
	
	public static void main(String[] args) throws InterruptedException{
		CondicionDeCarrera racer = new CondicionDeCarrera();
		Thread t1, t2;
		t1 = new Thread(racer);
		t2 = new Thread(racer);
		
		t1.start();
		t2.start();
		
		long resultadoEsperado = NUMERO_SUMADO * NUM_VECES * 2;
		
		t1.join();
		t2.join();
		
		System.out.println("El resultado final es " +racer.getSuma());

		System.out.println("Esperábamos " +resultadoEsperado);
		
		if (racer.getSuma()!=resultadoEsperado) System.out.println("¡NO COINCIDEN!");
	

	}
	private volatile long _suma = 0;
}
