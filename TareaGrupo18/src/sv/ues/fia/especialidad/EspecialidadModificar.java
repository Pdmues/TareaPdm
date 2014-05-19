package sv.ues.fia.especialidad;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EspecialidadModificar extends Activity {

	ControladorBDG18 helper;
	EditText editMCEsp;
	EditText editMCDFEsp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_especialidad_modificar);
		helper = new ControladorBDG18(this);
		editMCEsp = (EditText) findViewById(R.id.editMCEspecialidad);
		editMCDFEsp = (EditText) findViewById(R.id.editMCFMaestro);
	}

	public void actualizarEspecialidad(View v) 
	{
		Especialidad especialidad = new Especialidad();
		especialidad.setIdEspecialidad(Integer.parseInt(editMCEsp.getText().toString()));
		especialidad.setIdmaestro(editMCDFEsp.getText().toString());
		helper.abrir();
		String estado = helper.actualizar(especialidad);
		helper.cerrar();
		Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
	}
	public void limpiarTexto(View v) 
	{
		editMCEsp.setText("");
		editMCDFEsp.setText("");
	}
	

}
