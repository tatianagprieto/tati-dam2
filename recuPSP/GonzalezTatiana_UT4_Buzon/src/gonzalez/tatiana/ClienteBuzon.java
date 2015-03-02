package gonzalez.tatiana;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class ClienteBuzon extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private static JTextArea taMensajesRecibidos;
	private static JComboBox cbDestinatario;
	private JButton btnEnviar;
	private static JTextField tfMensaje;
	private static Socket cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteBuzon frame = new ClienteBuzon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			cliente = new Socket("localhost", 56789);
		} catch (UnknownHostException e) {
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
	public ClienteBuzon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		tfUsuario = new JTextField();
		tfUsuario.setColumns(10);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//Enviamos nuestro nombre al servidor
					DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
					dos.writeUTF(tfUsuario.getText());
					//habilitamos los controles
					tfMensaje.setEditable(true);
					btnEnviar.setEnabled(true);
					cbDestinatario.setEnabled(true);
					//llenamos el comboBox con los usuarios del sistema
					
					//Leemos los mensajes pendientes y los mostramos 
					ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
					ArrayList<Mensaje> mensajesPendientes = (ArrayList<Mensaje>) ois.readObject();
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		taMensajesRecibidos = new JTextArea();
		taMensajesRecibidos.setEditable(false);
		
		cbDestinatario = new JComboBox();
		cbDestinatario.setEnabled(false);
		
		btnEnviar = new JButton("Enviar mensaje");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//
					UsuarioBuzon remitente = new UsuarioBuzon(tfUsuario.getText());
					UsuarioBuzon destinatario = (UsuarioBuzon) cbDestinatario.getSelectedItem();
					Calendar ahora = Calendar.getInstance();
					//enviar mensaje
					Mensaje mensaje = new Mensaje(remitente, destinatario, ahora, tfMensaje.getText());
					ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
					oos.writeObject(mensaje);
					//Limpiamos el campo y cerramos el stream
					tfMensaje.setText("");
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnEnviar.setEnabled(false);
		
		tfMensaje = new JTextField();
		tfMensaje.setEnabled(false);
		tfMensaje.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(82)
							.addComponent(tfUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(btnConectar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(taMensajesRecibidos, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnEnviar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cbDestinatario, 0, 120, Short.MAX_VALUE))
									.addGap(18)
									.addComponent(tfMensaje)))))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConectar))
					.addGap(26)
					.addComponent(taMensajesRecibidos, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cbDestinatario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnEnviar))
						.addComponent(tfMensaje, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
