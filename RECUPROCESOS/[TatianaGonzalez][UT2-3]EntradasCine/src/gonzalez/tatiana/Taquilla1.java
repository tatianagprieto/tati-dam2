package gonzalez.tatiana;

public class Taquilla1 implements Runnable{
	private Cine cine;
	
	public Taquilla1(Cine cine){
		this.cine = cine;
	}
	
	public void run(){
		synchronized(cine){
		cine.vender(3,1);
		cine.vender(2,1);
		cine.vender(2,2);
		cine.devolver(3,1);
		cine.vender(5,1);
		cine.vender(2,2);
		cine.vender(2,2);
		cine.vender(2,2);
		}
	}
}
