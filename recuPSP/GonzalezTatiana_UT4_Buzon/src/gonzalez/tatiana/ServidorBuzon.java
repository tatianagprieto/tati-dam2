package gonzalez.tatiana;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class ServidorBuzon extends JFrame implements MetodosRemotos{

	private JPanel contentPane;
	static JTextArea logServidor;
	private ArrayList<UsuarioBuzon> usuariosRegistrados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServidorBuzon frame = new ServidorBuzon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			//Cargamos el archivo que contiene los usuarios
			File archivoUsuarios = new File("usuarios.data");
			ArrayList<UsuarioBuzon> usuarios;
			if(archivoUsuarios.exists()){
				System.out.println("Cargando datos");
				//Cargamos los datos
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoUsuarios));
				usuarios = (ArrayList<UsuarioBuzon>) ois.readObject();
			}else{
				System.out.println("Creando archivo");
				archivoUsuarios.createNewFile();
				usuarios = new ArrayList<UsuarioBuzon>();
			}
			System.out.println("Creando objeto remoto");
			//Creamos el objeto remoto
			ServidorBuzon servidor = new ServidorBuzon();
			System.out.println("Creando stub");
			MetodosRemotos stub = (MetodosRemotos) UnicastRemoteObject.exportObject(servidor, 0);
			//Enlazamos
			System.out.println("Instanciando registro...");
			Registry registro = LocateRegistry.getRegistry();
			System.out.println("Binding...");
			registro.bind("MetodosRemotos", stub);
			//logServidor.append("Servidor iniciado...\n");
			/*
			
			//Creamos el socket para recibir las peticiones
			ServerSocket servidor = new ServerSocket(56789);
			while (true) {
				Socket cliente = servidor.accept();
				//Recibimos el nombre del usuario
				DataInputStream dis = new DataInputStream(cliente.getInputStream());
				String nombreUsuario = dis.readUTF();
				logServidor.append("/n Atendiendo a " +nombreUsuario +" (" +cliente.getInetAddress() +":" +cliente.getPort() +")");
				//Lanzamos el hilo que atiende al cliente
				Thread hilo = new Thread(new AtenderUsuario(nombreUsuario, cliente));
			}//while
*/		} catch (Exception e) {
			//No tratamos las excepciones de ninguna forma
			System.out.println("Algo malo ocurrió :(");
			System.out.println(e.getStackTrace());
		}
		
	}

	/**
	 * Create the frame.
	 */
	public ServidorBuzon() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				//Cuando se va a cerrar la ventana, tenemos que guardar la info de los usuarios registrados
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		logServidor = new JTextArea();
		logServidor.setEditable(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(logServidor, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(logServidor, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	//Implementación de MetodosRemotos
	
	@Override
	public ArrayList<String> cargarUsuarios() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioBuzon getUsuario() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enviarMensaje(UsuarioBuzon destinatario) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
