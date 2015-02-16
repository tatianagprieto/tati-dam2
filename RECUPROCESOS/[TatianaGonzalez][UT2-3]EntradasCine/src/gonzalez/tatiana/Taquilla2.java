package gonzalez.tatiana;

public class Taquilla2 implements Runnable{
	private Cine cine;
	
	public Taquilla2(Cine cine){
		this.cine = cine;
	}
	
	public void run(){
		synchronized(cine){
		cine.vender(2,2);
		cine.vender(4,2);
		cine.vender(2,1);
		cine.vender(1,1);
		cine.devolver(2,2);
		cine.vender(3,1);
		cine.vender(2,2);
		cine.vender(2,1);
		}
	}
}