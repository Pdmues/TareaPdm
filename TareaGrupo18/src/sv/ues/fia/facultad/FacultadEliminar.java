package sv.ues.fia.facultad;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FacultadEliminar extends Activity {
	EditText editEcfacu;
	ControladorBDG18 controlhelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facultad_eliminar);
		controlhelper=new ControladorBDG18 (this);
		editEcfacu=(EditText)findViewById(R.id.editECFacu);
	}

	public void eliminarCarrera(View v)
	{
		String regEliminadas;
		Facultad facultad = new Facultad();
		facultad.getIDfacultad();
		controlhelper.abrir();
		regEliminadas=controlhelper.eliminar(facultad);
		controlhelper.cerrar();
		Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
	}
}