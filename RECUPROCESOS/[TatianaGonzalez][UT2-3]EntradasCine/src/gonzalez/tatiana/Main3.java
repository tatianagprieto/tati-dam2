package gonzalez.tatiana;

public class Main3 {
	
	public static void main(String[] args) {
		int NUMERO_ASIENTOS_1 = 25;
		int NUMERO_ASIENTOS_2 = 24;
		
		Cine cine = new Cine(NUMERO_ASIENTOS_1,NUMERO_ASIENTOS_2);
		Thread taquilla1 = new Thread(new Taquilla1(cine), "taquilla1");
		Thread taquilla2 = new Thread(new Taquilla2(cine), "taquilla2");

		taquilla1.start();
		taquilla2.start();

		try {
			taquilla1.join();
			taquilla2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ASIENTOS LIBRES SALA 1: " +cine.getAsientosSala(1));
		System.out.println("ASIENTOS LIBRES SALA 2: " +cine.getAsientosSala(2));
	}
	
}
