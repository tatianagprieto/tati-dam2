package gonzalezTatiana.evaluacion1;

import java.util.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class GonzalezPrietoTatiana extends Activity implements OnClickListener{

	ArrayList<RadioButton> coloresJugador1;
	ArrayList<RadioButton> coloresJugador2;
	
	EditText nombreJugador1, nombreJugador2;
	
	Button aJugar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gonzalez_prieto_tatiana);
		
        
        //Vistas
        vsOtro = (RadioButton) findViewById(R.id.vsOtro);
        vsCPU = (RadioButton) findViewById(R.id.vsCPU);
        jugar = (Button) findViewById(R.id.botonComenzarJuego);
        
        //Listener
        jugar.setOnClickListener(this);
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
