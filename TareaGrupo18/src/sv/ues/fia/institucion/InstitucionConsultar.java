package sv.ues.fia.institucion;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InstitucionConsultar extends Activity {

	EditText editCInst;
	EditText editNInst;
	ControladorBDG18 helper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_institucion_consultar);
		helper = new ControladorBDG18(this);
		editCInst = (EditText) findViewById(R.id.editCCInts);
		editNInst = (EditText) findViewById(R.id.editCNInst);
	}


	public void consultarInstitucion(View v) 
	{
		helper.abrir();
		Institucion institu=helper.consultarInstitucion(editCInst.getText().toString());
		helper.cerrar();
		if(institu == null)
		Toast.makeText(this, "La institucion con codigo " +
				editCInst.getText().toString() +
		" no encontrado", Toast.LENGTH_LONG).show();
		else
		{
			editNInst.setText(institu.getNombreinstitucion().toString());
		}
	}
	public void limpiarTexto(View v)
	{
		editCInst.setText("");
		editNInst.setText("");
	}

}
