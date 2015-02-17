package gonzalez.tatiana;

public class Main9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer buffer = new Buffer(10);
		Thread productor = new Thread(new Productor(buffer));
		Thread consumidor = new Thread(new Consumidor(buffer));
		Thread consumidor2 = new Thread(new Consumidor(buffer));
		
		productor.start();
		consumidor.start();
		//consumidor2.start();
		
		try {
			productor.join();
			consumidor.join();
			//consumidor2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Número de elementos en el buffer: " +buffer.getTamanhoAlmacen());
	
	}

}
