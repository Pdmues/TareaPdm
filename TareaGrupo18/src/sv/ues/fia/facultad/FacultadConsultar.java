package sv.ues.fia.facultad;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FacultadConsultar extends Activity {

	EditText editIDFacultad;
	EditText editNFacultad;
	ControladorBDG18 helper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facultad_consultar);
		helper = new ControladorBDG18(this);
		editIDFacultad = (EditText) findViewById(R.id.editCFacu);
		editNFacultad = (EditText) findViewById(R.id.editCCfac);
	}

	public void consultarFacultad(View v) 
	{
		helper.abrir();
		Facultad facultad=helper.consultarFacultad(editIDFacultad.getText().toString());
		helper.cerrar();
		if(facultad == null)
		Toast.makeText(this, "La facultad con codigo " +	editIDFacultad.getText().toString() +" no encontrado", Toast.LENGTH_LONG).show();
		else
		{
			editNFacultad.setText(facultad.getIDfacultad().toString());
		}
	}
	public void limpiarTexto(View v)
	{
		editIDFacultad.setText("");
		editNFacultad.setText("");
	}

}
