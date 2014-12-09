package gonzalezTatiana.evaluacion1;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Partida extends Activity implements OnClickListener {
	Jugador jugador1, jugador2, jugadorActual;
	//String nombre1, nombre2;
	String mensaje, resultadoPartida;
	boolean partidaFinalizada = false;
	MediaPlayer musica;
	int posicionMusica = 0;
	//Elemntos de la interfaz
	ArrayList<ImageButton> boton;
	Tablero tablero;
	TextView textoTurno;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_partida);
	
		jugador1 = (Jugador) getIntent().getExtras().getSerializable("jugador1");
		jugador2 = (Jugador) getIntent().getExtras().getSerializable("jugador2");
		jugadorActual = jugador1;
		textoTurno = (TextView) findViewById(R.id.textoVersus);
		mensaje = getResources().getString(R.string.turno);
		textoTurno.setText(String.format(mensaje, jugadorActual.getNombre()));
		//textoTurno.setTextColor(jugador1.getColor());
		
		tablero = new Tablero();
		boton = new ArrayList<ImageButton>();
		boton.add((ImageButton) findViewById(R.id.TL));
		boton.add((ImageButton) findViewById(R.id.TC));
		boton.add((ImageButton) findViewById(R.id.TR));
		boton.add((ImageButton) findViewById(R.id.ML));
		boton.add((ImageButton) findViewById(R.id.MC));
		boton.add((ImageButton) findViewById(R.id.MR));
		boton.add((ImageButton) findViewById(R.id.BL));
		boton.add((ImageButton) findViewById(R.id.BC));
		boton.add((ImageButton) findViewById(R.id.BR));
		
		for (ImageButton b: boton){
			b.setOnClickListener(this);
		}
//		
      //Música
//      musica = MediaPlayer.create(this, R.raw.ost);
//      try {
//			musica.prepare();
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//      musica.start();
	}//fin onCreate()

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.partida, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.volver) {
			volver();
			return true;
		}
		else if (id == R.id.salir){
			salir();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void volver(){
		//
		if (partidaFinalizada){
			//devolver resultado partida
			
			//guardar partida en historico
			
			startActivity(new Intent(Partida.this,
					GonzalezPrietoTatiana.class));
		}
		else{
			//mostramos una alerta de que la partida está encurso
			AlertDialog.Builder alerta = new AlertDialog.Builder(this);
			alerta.setMessage(R.string.partidaEnCurso);
			alerta.setPositiveButton(android.R.string.ok, null);
			alerta.show();
		}
	}
	
	public void salir(){
		
	}

	@Override
	public void onClick(View v) {
		//invocamos al método marcar casilla
		int id = v.getId();
		switch (id){
		case R.id.TL:
			tablero.setCasillaSeleccionada(tablero.getCasilla(0));
			break;
		case R.id.TC:
			tablero.setCasillaSeleccionada(tablero.getCasilla(1));
			break;
		case R.id.TR:
			tablero.setCasillaSeleccionada(tablero.getCasilla(2));
			break;
		case R.id.ML:
			tablero.setCasillaSeleccionada(tablero.getCasilla(3));
			break;
		case R.id.MC:
			tablero.setCasillaSeleccionada(tablero.getCasilla(4));
			break;
		case R.id.MR:
			tablero.setCasillaSeleccionada(tablero.getCasilla(5));
			break;
		case R.id.BL:
			tablero.setCasillaSeleccionada(tablero.getCasilla(6));
			break;
		case R.id.BC:
			tablero.setCasillaSeleccionada(tablero.getCasilla(7));
			break;
		case R.id.BR:
			tablero.setCasillaSeleccionada(tablero.getCasilla(8));
			break;
		}
		
		

		if (tablero.getCasillaSeleccionada().getEstado()==EstadoCasilla.VACIA){
		//Si está vacía, la marcamos
			tablero.getCasillaSeleccionada().marcarCasilla(jugadorActual);
			tablero.incrementarNumeroCasillasMarcadas();
			v.setBackgroundColor(jugadorActual.getColor());
			if (tablero.bloquearTablero()){
				partidaFinalizada = true;
				guardarEnHistorico();
				
				for (ImageButton b: boton){b.setClickable(false);				}
				//o hay tres en raya..
				if (tablero.hayTresEnRaya()){
					resultadoPartida = String.format(getResources().getString(R.string.resultadoGanador), jugadorActual.getNombre());
					mensaje = String.format(getResources().getString(R.string.ganador), jugadorActual.getNombre());
					Toast t = Toast.makeText(this, mensaje, Toast.LENGTH_LONG);
					t.show();
				}
				//o hay empate
				else{
					resultadoPartida = String.format(getResources().getString(R.string.resultadoEmpate));
					Toast t = Toast.makeText(this, getResources().getString(R.string.empate), Toast.LENGTH_LONG);
					t.show();
				}
			}
			else{
				//cambiamos turno
				cambiarTurno();
				textoTurno.setText(String.format(getResources().getString(R.string.turno), jugadorActual.getNombre()));
				
			}
		}
		else{
		//Si la casilla no está vacía, mostrar mensaje
			AlertDialog.Builder alerta = new AlertDialog.Builder(this);
			alerta.setMessage(R.string.avisoTrampa);
			alerta.setPositiveButton(android.R.string.ok, null);
			alerta.show();
		}

	}

	private void guardarEnHistorico() {
		try {
			// TODO Auto-generated method stub
//			InputStream fichero = getResources().openRawResource(R.raw.historico);
//			BufferedReader lector = new BufferedReader(new InputStreamReader(fichero));
			FileOutputStream fichero = openFileOutput("historico.txt", Context.MODE_PRIVATE | Context.MODE_APPEND);
			OutputStreamWriter escritor = new OutputStreamWriter(fichero);
			escritor.write(jugador1.getNombre() +" VS" +jugador2.getNombre() +"\n");
			escritor.write(resultadoPartida +"\n");
			escritor.close();
		} catch (Exception e) {
			Log.e("Ficheros", "Error al acceder al fichero de histórico.");
		}
	}

	private void cambiarTurno() {
		// TODO Auto-generated method stub
		if (jugadorActual==jugador1) jugadorActual = jugador2;
		else jugadorActual = jugador1;
	}

	
}
