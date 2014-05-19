package sv.ues.fia.alumno;

import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AlumnoModificar extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alumno_modificar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alumno_modificar, menu);
		return true;
	}

}
