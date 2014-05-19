package sv.ues.fia.alumno;

import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AlumnoConsultar extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alumno_consultar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alumno_consultar, menu);
		return true;
	}

}
