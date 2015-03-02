package gonzalez.tatiana;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class ServidorTCP extends JFrame {

	private JPanel contentPane;
	static JTextArea taMensajes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			/* (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 */
			public void run() {
				try {
					ServidorTCP frame = new ServidorTCP();
					frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			
			ServerSocket servidor;
		try {
			//Creamos el socket y ponemos el servidor a la escucha
			servidor = new ServerSocket(55555);
			while(true){

				Socket cliente = servidor.accept();
				//Conectamos un flujo de entrada desde el cliente
				ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
				//Leemos el mensaje enviado por el cliente
				Mensaje mensaje = (Mensaje) ois.readObject();
				//Lo mostramos en el textArea
				taMensajes.append(cliente.getInetAddress() +"(" +cliente.getPort() +"):   " +mensaje.toString() +"\n");
				mensaje = new Mensaje(mensaje.getTipo()+100, mensaje.getTexto().toUpperCase());
				ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
				oos.writeObject(mensaje);
				
				//Cerramos streams y sockets
				ois.close();
				oos.close();
				cliente.close();
				//servidor.close();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public ServidorTCP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblMensajesRecibidos = new JLabel("Mensajes recibidos");
		lblMensajesRecibidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		taMensajes = new JTextArea();
		taMensajes.setEditable(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(taMensajes, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
						.addComponent(lblMensajesRecibidos))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMensajesRecibidos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(taMensajes, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
