package gonzalezTatiana.evaluacion1;

import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class GonzalezPrietoTatiana extends Activity
implements OnCheckedChangeListener, OnClickListener{

//	ArrayList<RadioButton> coloresJugador1;
//	ArrayList<RadioButton> coloresJugador2;
	
	RadioButton naranja1, azul1, verde1, naranja2, azul2, verde2;
	RadioGroup colores1,colores2;
	EditText nombreJugador1, nombreJugador2;	
	Button aJugar;
	Jugador jugador1, jugador2;
	MediaPlayer musica;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gonzalez_prieto_tatiana);
		
//        
//        //Vistas
		colores1 = (RadioGroup) findViewById(R.id.seleccion1);
		colores2 = (RadioGroup) findViewById(R.id.seleccion2);
		
		
		naranja1 = (RadioButton) findViewById(R.id.naranja);
		verde1 = (RadioButton) findViewById(R.id.verde);
		azul1 = (RadioButton) findViewById(R.id.azul);
		naranja2 = (RadioButton) findViewById(R.id.naranja2);
		verde2 = (RadioButton) findViewById(R.id.verde2);
		azul2 = (RadioButton) findViewById(R.id.azul2);

        aJugar = (Button) findViewById(R.id.jugar);
        
        nombreJugador1 = (EditText) findViewById(R.id.nombre1);
        nombreJugador2 = (EditText) findViewById(R.id.nombre2);
        
        //Música
        musica = MediaPlayer.create(this, R.raw.ost);
        try {
			musica.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        musica.start();
        //Listener
       aJugar.setOnClickListener(this);
       colores1.setOnCheckedChangeListener(this);
       colores2.setOnCheckedChangeListener(this);
       
        
	}//fin clase

	protected void onResume(Bundle savedInstanceState){
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
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gonzalez_prieto_tatiana, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.acercaDe) {
			mostrarAcercaDe();
			return true;
		}
		else if (id == R.id.configuracion){
			lanzarActividadConfiguracion();
			return true;
		}
		else if (id == R.id.historico){
			lanzarActividadHistorico();
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}

	public void deshabilitarAnalogo(int checkedId){
		
		switch(checkedId){
		case R.id.naranja:
			azul2.setClickable(true);
			verde2.setClickable(true);
			naranja2.setClickable(false);
			return;
		case R.id.naranja2:
			azul1.setClickable(true);
			verde1.setClickable(true);
			naranja1.setClickable(false);
			return;
		case R.id.azul:
			naranja2.setClickable(true);
			verde2.setClickable(true);
			azul2.setClickable(false);
			return;
		case R.id.azul2:
			naranja1.setClickable(true);
			verde1.setClickable(true);
			azul1.setClickable(false);
			return;
		case R.id.verde:
			azul2.setClickable(true);
			naranja2.setClickable(true);
			verde2.setClickable(false);
			return;
		case R.id.verde2:
			azul1.setClickable(true);
			naranja1.setClickable(true);
			verde1.setClickable(false);
			return;
		}
	}//gestionarcolores)

	public int getColor(int id){
		
		switch (id){
		case R.id.naranja:
		case R.id.naranja2:
			return Color.parseColor("#FF9900");
		case R.id.azul:
		case R.id.azul2:
			return  Color.parseColor("#097054");
		case R.id.verde:
		case R.id.verde2:
			return Color.parseColor("#00628B");		
		}
		return 0;
	}
	
	public boolean mostrarAlerta(){
		AlertDialog.Builder alerta = new AlertDialog.Builder(this);
		alerta.setPositiveButton(android.R.string.ok, null);
		String mensaje;
		if(nombreJugador1.getText().toString().equals("")){
			mensaje = getResources().getString(R.string.avisoFaltaNombre);
			mensaje = String.format(mensaje, "1");
			alerta.setMessage(mensaje);
			alerta.show();
			return true;
		}	
		else if (nombreJugador2.getText().toString().equals("")){
			mensaje = getResources().getString(R.string.avisoFaltaNombre);
			mensaje = String.format(mensaje, "2");
			alerta.setMessage(mensaje);
			alerta.show();
			return true;
		}
		else if (nombreJugador1.getText().toString().equals(nombreJugador2.getText().toString())){
			mensaje = getResources().getString(R.string.avisoNombresIguales);
			alerta.setMessage(mensaje);
			alerta.show();
			return true;
		}
		else if (colores1.getCheckedRadioButtonId()==-1){
			mensaje = getResources().getString(R.string.avisoFaltaColor);
			mensaje = String.format(mensaje, "1");
			alerta.setMessage(mensaje);
			alerta.show();
			return true;
		}
		else if (colores2.getCheckedRadioButtonId()==-1){
			mensaje = getResources().getString(R.string.avisoFaltaColor);
			mensaje = String.format(mensaje, "2");
			alerta.setMessage(mensaje);
			alerta.show();
			return true;
		}
		return false;
	}//mostrarAlerta
	
	public void mostrarAcercaDe(){
		AlertDialog.Builder info = new AlertDialog.Builder(this);
		info.setMessage(R.string.autor);
		info.setTitle(R.string.acercaDe);
		info.show();
	}
	
	public void lanzarActividadConfiguracion(){
		startActivity(new Intent(GonzalezPrietoTatiana.this,
				PantallaConfiguracion.class));
	}
	
	public void lanzarActividadHistorico(){
		startActivity(new Intent(GonzalezPrietoTatiana.this, HistorialPartidas.class));
	}
	
	@Override
	public void onClick(View v) {
		//Está a la escucha del botón aJugar
		boolean faltanDatos = mostrarAlerta();
		if (!mostrarAlerta()){
			Intent partidaIntent = new Intent(GonzalezPrietoTatiana.this, Partida.class);
			jugador1 = new Jugador(nombreJugador1.getText().toString(), getColor(colores1.getCheckedRadioButtonId()));
			jugador1.setEstadoAsociado(EstadoCasilla.JUGADOR_1);
			jugador2 = new Jugador(nombreJugador2.getText().toString(), getColor(colores2.getCheckedRadioButtonId()));
			jugador2.setEstadoAsociado(EstadoCasilla.JUGADOR_2);
			partidaIntent.putExtra("jugador1", jugador1);
			partidaIntent.putExtra("jugador2", jugador2);
	//		partidaIntent.putExtra("nombre1", "Lolo");
	//		partidaIntent.putExtra("nombre2", nombreJugador2.getText().toString());
	//		partidaIntent.putExtra("color1", getColor(colores1.getCheckedRadioButtonId()));
	//		partidaIntent.putExtra("color2", getColor(colores2.getCheckedRadioButtonId()));
			
	        partidaIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
	        startActivity(partidaIntent);
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		deshabilitarAnalogo(checkedId);
	}
}
