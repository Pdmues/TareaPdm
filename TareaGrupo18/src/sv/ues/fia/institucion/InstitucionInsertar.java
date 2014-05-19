package sv.ues.fia.institucion;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InstitucionInsertar extends Activity {

	ControladorBDG18 helper;
	EditText editCodigoInst;
	EditText editNombreInst;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_institucion_insertar);
		helper = new ControladorBDG18(this);
		editCodigoInst = (EditText) findViewById(R.id.editCINstitucion);
		editNombreInst = (EditText) findViewById(R.id.editNInstitucion);
	}


	public void insertarInstitucion(View v) 
	{
		String cinstitucion=editCodigoInst.getText().toString();
		String ninstitucion=editNombreInst.getText().toString();
		String regInsertados;
		Institucion institucion=new Institucion();
		institucion.setIdindtitucion(Integer.parseInt(cinstitucion));
		institucion.setNombreinstitucion(ninstitucion);
		helper.abrir();
		regInsertados=helper.insertar(institucion);
		helper.cerrar();
		Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
	}
	public void limpiarTexto(View v) 
	{
		editCodigoInst.setText("");
		editNombreInst.setText("");
	}

}
