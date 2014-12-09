package gonzalezTatiana.evaluacion1;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PantallaConfiguracion extends PreferenceActivity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	addPreferencesFromResource(R.xml.configuracion);
	}
}
