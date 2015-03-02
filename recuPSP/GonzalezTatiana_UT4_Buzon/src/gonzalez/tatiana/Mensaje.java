package gonzalez.tatiana;

import java.util.Calendar;

public class Mensaje {
	private UsuarioBuzon remitente;
	private UsuarioBuzon destinatario;
	private Calendar fecha;
	private String texto;
	public UsuarioBuzon getRemitente() {
		return remitente;
	}
	public void setRemitente(UsuarioBuzon remitente) {
		this.remitente = remitente;
	}
	public UsuarioBuzon getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(UsuarioBuzon destinatario) {
		this.destinatario = destinatario;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Mensaje(UsuarioBuzon remitente, UsuarioBuzon destinatario, Calendar fecha, String texto) {
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.fecha = fecha;
		this.texto = texto;
	}
	@Override
	public String toString() {
		return "*********** Mensaje de " + remitente + " - Fecha: " +fecha +" **********\n" +texto;
	}
	
	
}
