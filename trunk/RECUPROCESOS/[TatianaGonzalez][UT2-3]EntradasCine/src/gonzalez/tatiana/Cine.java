package gonzalez.tatiana;

public class Cine {
	private int[] asientosSala = new int[3];


	
	public int getAsientosSala(int i) {
		return asientosSala[i];
	}

	public void setAsientosSala(int[] asientosSala) {
		this.asientosSala = asientosSala;
	}

	//Constructor
	public Cine(int asientosSala1, int asientosSala2){
		this.asientosSala[1] = asientosSala1;
		this.asientosSala[2] = asientosSala2; 
	}
	
	//synchronized 
	public boolean vender(int numeroTickets, int numeroSala){
		if (numeroTickets <= asientosSala[numeroSala]){
			asientosSala[numeroSala] -= numeroTickets;
			System.out.println(Thread.currentThread().getName() + " operando:");
			System.out.println("Vendidas " +numeroTickets +" en sala " +numeroSala);
			System.out.println("   Quedan " +asientosSala[numeroSala] +" en sala " +numeroSala);
			return true;
		}else{
			System.out.println("Venta fallida");
			return false;
		}

	}//vender
	
	//synchronized 
	public boolean devolver(int numeroTickets, int numeroSala){
			asientosSala[numeroSala] += numeroTickets;
			System.out.println("Vendidas " +numeroTickets +" en sala " +numeroSala);
			System.out.println("DEVOLUCIÓN: Quedan " +asientosSala[numeroSala] +" en sala " +numeroSala);
			return true;

	}//devolver
	
}//clase
