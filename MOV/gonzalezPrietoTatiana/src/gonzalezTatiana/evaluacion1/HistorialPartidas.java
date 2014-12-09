package gonzalezTatiana.evaluacion1;

import java.io.FileInputStream;
import java.util.Scanner;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class HistorialPartidas extends Activity{
	ListView listado;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_historial_partidas);
		listado = (ListView) findViewById(R.id.listadoPartidas);
		String linea1, linea2;
		try{
			FileInputStream fichero = openFileInput("historico.txt");
			Scanner scanner = new Scanner(fichero);
			do{
				linea1 = scanner.nextLine();
				linea2 = scanner.nextLine();
				TextView tv= new TextView(this);
				//tv.setLayoutParams(android.R.layout.simple_list_item_2);
				tv.setText(linea1);
				listado.addView(tv);
			}while(scanner.hasNextLine());
		}
		catch(Exception e){
			Log.e("Ficheros","Error al leer fichero historico.txt");
		}
	}
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.partida, menu);
//		return true;
//	}
	
}//fin actividad
