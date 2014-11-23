package gonzalezTatiana.evaluacion1;

public enum PosicionCasilla {
	TL(-1,-1,true),
	TC(-1,0,false),
	TR(-1,1,false),
	ML(0,-1,false), 
	MC(0,0,true), 
	MR(0,1,false), 
	BL(1,-1,false), 
	BC(1,0,false), 
	BR(1,1,true);

	private int fila, columna;
	private boolean enDiagonalSecundaria;
	public int getFila(){return this.fila;}
	public int getColumna(){return this.columna;}
	public boolean estaEnDiagonalSecundaria(){return this.enDiagonalSecundaria;}
	
	 PosicionCasilla(int fila, int columna, boolean diagonal){
		 this.fila = fila;
		 this.columna = columna;
		 this.enDiagonalSecundaria = diagonal;
	 }
	 
	 public int sumaPosiciones(){
		 return fila +columna;
	 }
	 
}//end enum PosicionesCasillas
