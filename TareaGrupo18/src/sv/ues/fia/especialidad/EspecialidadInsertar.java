package sv.ues.fia.especialidad;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EspecialidadInsertar extends Activity {

	ControladorBDG18 helper;
	EditText editCodigoEsp;
	EditText editCFMAestro;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_especialidad_insertar);
		helper = new ControladorBDG18(this);
		editCodigoEsp = (EditText) findViewById(R.id.editICEspecialidad);
		editCFMAestro = (EditText) findViewById(R.id.editINEspecialidad);
	}

	public void insertarEspecialidad(View v) 
	{
		String cespecialidad=editCodigoEsp.getText().toString();
		String nespecialidad=editCFMAestro.getText().toString();
		String regInsertados;
		Especialidad especialidad=new Especialidad();
		especialidad.setIdEspecialidad(Integer.parseInt(cespecialidad));
		especialidad.setIdmaestro(nespecialidad);
		helper.abrir();
		regInsertados=helper.insertar(especialidad);
		helper.cerrar();
		Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
	}
	public void limpiarTexto(View v) 
	{
		editCodigoEsp.setText("");
		editCFMAestro.setText("");
	}

}
