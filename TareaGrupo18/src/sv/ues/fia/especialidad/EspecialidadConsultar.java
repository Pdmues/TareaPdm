package sv.ues.fia.especialidad;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EspecialidadConsultar extends Activity {

	EditText editCEsp;
	EditText editCDoc;
	ControladorBDG18 helper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_especialidad_consultar);
		helper = new ControladorBDG18(this);
		editCEsp = (EditText) findViewById(R.id.editCCEsp);
		editCDoc = (EditText) findViewById(R.id.editCCDoc);
	}

	public void consultarEspecialidad(View v) 
	{
		if(editCEsp.getText().toString().equals(""))
		{
			Toast.makeText(this, "Campos vacios", Toast.LENGTH_LONG).show();
			editCEsp.setText("");
			editCDoc.setText("");
		}
		else
		{
			helper.abrir();
			Especialidad especia=helper.consultarEspecialidad(editCEsp.getText().toString());
			helper.cerrar();
			if(especia == null)
			Toast.makeText(this, "La institucion con codigo " +
					editCEsp.getText().toString() +
			" no encontrado", Toast.LENGTH_LONG).show();
			else
			{
				editCDoc.setText(especia.getIdmaestro().toString());
			}
		}
	}
	public void limpiarTexto(View v)
	{
		editCEsp.setText("");
		editCDoc.setText("");
	}
	

}
