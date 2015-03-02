package gonzalez.tatiana;

import java.util.Calendar;

public class Mensaje {

	private Calendar fecha;
	private Usuario remitente;
	private Usuario destinatario;
	private String texto;
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public Usuario getRemitente() {
		return remitente;
	}
	public void setRemitente(Usuario remitente) {
		this.remitente = remitente;
	}
	public Usuario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	@Override
	public String toString() {
		return "Mensaje de: " +remitente +"\n Enviado: " +fecha.getTime() +"\n " +texto;
	}
	public Mensaje(Calendar fecha, Usuario remitente, Usuario destinatario,
			String texto) {
		super();
		this.fecha = fecha;
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.texto = texto;
	}
	
	

}//mensaje
