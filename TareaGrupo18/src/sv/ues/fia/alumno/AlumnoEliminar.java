package sv.ues.fia.alumno;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import sv.ues.fia.institucion.Institucion;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AlumnoEliminar extends Activity {

	EditText editElimCarnet;
	ControladorBDG18 controlhelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alumno_eliminar);
		controlhelper = new ControladorBDG18 (this);
		//editElimCarnet = (EditText)findViewById(R.id.editElimCarnet);
		
	}

	public void eliminarInstitucion(View v)
	{
		String regEliminadas;
		Alumno alumn = new Alumno();
		alumn.setCarnet(editElimCarnet.getText().toString());
		controlhelper.abrir();
		//regEliminadas = controlhelper.eliminar(alumn);
		controlhelper.cerrar();
		//Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
	}

}
