package gonzalez.tatiana;

public class Libro {
	private String titulo;
	private String genero;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public Libro(String t, String g){
		titulo = t;
		genero = g;
	}
	
	public String toString(){
		return titulo +" - " +genero;
	}
}
