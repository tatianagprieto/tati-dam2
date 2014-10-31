package vk.tati;

public class Contador {
	private int _c = 0;
	public final int NUMVECES = 10;
	public Contador(int c){_c = c;}
	public void incrementa(){++this._c;}
	public void decrementa(){--this._c;}
	public int getValue(){return _c;}
}
