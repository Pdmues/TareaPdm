package sv.ues.fia.institucion;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InstitucionModificar extends Activity {

	ControladorBDG18 helper;
	EditText editMCInst;
	EditText editMNInst;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_institucion_modificar);
		helper = new ControladorBDG18(this);
		editMCInst = (EditText) findViewById(R.id.editMCInstitucion);
		editMNInst = (EditText) findViewById(R.id.editMInstitucion);
	}

	public void actualizarInstitucion(View v) 
	{
		if(editMCInst.getText().toString().equals("")||editMNInst.getText().toString().equals(""))
		{
			Toast.makeText(this, "Campos vacios", Toast.LENGTH_LONG).show();
			editMCInst.setText("");
			editMNInst.setText("");
		}
		else
		{
			Institucion institucion = new Institucion();
			institucion.setIdindtitucion(Integer.parseInt(editMCInst.getText().toString()));
			institucion.setNombreinstitucion(editMNInst.getText().toString());
			helper.abrir();
			String estado = helper.actualizar(institucion);
			helper.cerrar();
			Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
		}
	}
	public void limpiarTexto(View v) 
	{
		editMCInst.setText("");
		editMNInst.setText("");
	}



}
