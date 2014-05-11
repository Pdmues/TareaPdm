package sv.ues.fia.especialidad;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.institucion.Institucion;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EspecialidadEliminar extends Activity {
	EditText editECEsp;
	ControladorBDG18 controlhelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_especialidad_eliminar);
		controlhelper=new ControladorBDG18 (this);
		editECEsp=(EditText)findViewById(R.id.editEEspecialidad);
	}

	public void eliminarEspecialidad(View v)
	{
		String regEliminadas;
		Especialidad especialidad=new Especialidad();
		especialidad.setIdEspecialidad(Integer.parseInt(editECEsp.getText().toString()));
		controlhelper.abrir();
		regEliminadas=controlhelper.eliminar(especialidad);
		controlhelper.cerrar();
		Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
	}

}
