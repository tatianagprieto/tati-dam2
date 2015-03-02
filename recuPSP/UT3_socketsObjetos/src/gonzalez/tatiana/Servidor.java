package gonzalez.tatiana;

import java.awt.EventQueue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Servidor extends JFrame {

	private JPanel contentPane;
	protected static JTextArea texto;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					Servidor frame = new Servidor();
					frame.setVisible(true);
					texto.setText("Mensajes... \n");
					ServerSocket serverSocket = new ServerSocket(9876);
					Socket cliente = serverSocket.accept();
					//preparamos flujo de entrada
					ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
					Mensaje mensaje = (Mensaje) ois.readObject();
					System.out.println(mensaje);
					texto.setText(mensaje +"/n");
					mensaje = transformar(mensaje);
					ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
					oos.writeObject(mensaje);
					oos.close();
					ois.close();
					cliente.close();
					while (true){
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Servidor() {
		setTitle("Servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JLabel lblMensajesRecibidos = new JLabel("Mensajes Recibidos");
		//lblMensajesRecibidos.setBounds(10, 0, 154, 14);
		//contentPane.add(lblMensajesRecibidos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 422, 229);
		contentPane.add(scrollPane);
		
		texto = new JTextArea();
		scrollPane.setViewportView(texto);
	}
	public JTextArea getMensajes() {
		return texto;
	}
	
	private static Mensaje transformar(Mensaje mensaje){
		return new Mensaje(mensaje.getTipo()+100,mensaje.getTexto().toUpperCase());
	}

}
