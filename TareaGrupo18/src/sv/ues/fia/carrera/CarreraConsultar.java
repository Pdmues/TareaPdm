package sv.ues.fia.carrera;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CarreraConsultar extends Activity {

	EditText editCCarrera;
	EditText editCNcarrera;
	ControladorBDG18 helper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_especialidad_consultar);
		helper = new ControladorBDG18(this);
		editCCarrera = (EditText) findViewById(R.id.editCCEsp);
		editCNcarrera = (EditText) findViewById(R.id.editCCDoc);
	}

	public void consultarCarrera(View v) 
	{
		helper.abrir();
		Carrera carrera=helper.consultarCarrera(editCNcarrera.getText().toString());
		helper.cerrar();
		if(carrera == null)
		Toast.makeText(this, "La institucion con codigo " +	editCCarrera.getText().toString() +
		" no encontrado", Toast.LENGTH_LONG).show();
		else
		{
			editCNcarrera.setText(carrera.getIdcarrera().toString());
		}
	}
	public void limpiarTexto(View v)
	{
		editCCarrera.setText("");
		editCNcarrera.setText("");
	}
	
}
