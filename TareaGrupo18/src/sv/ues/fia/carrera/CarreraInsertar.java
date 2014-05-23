package sv.ues.fia.carrera;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CarreraInsertar extends Activity {

	ControladorBDG18 helper;
	EditText editIdcarr;
	EditText editNmcarr;
	EditText editfacultad;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carrera_insertar);
		helper = new ControladorBDG18(this);
		editIdcarr = (EditText) findViewById(R.id.editICcarrera);
		editNmcarr = (EditText) findViewById(R.id.editINNomb);
		editfacultad=(EditText) findViewById(R.id.editfacu);
	}

	public void insertarCarrera(View v) 
	{
		String codcarrera=editIdcarr.getText().toString();
		String Nomcarr= editNmcarr.getText().toString();
		String idfacultad = editfacultad.getText().toString();
		String regInsertados;
		Carrera carrera=new Carrera();
		carrera.setIdcarrera(codcarrera);
		carrera.setNombcarrera(Nomcarr);
		carrera.setIdfacultad(idfacultad);
		helper.abrir();
		regInsertados=helper.insertar(carrera);
		helper.cerrar();
		Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
	}
	public void limpiarTexto(View v) 
	{
		editIdcarr.setText("");
		editNmcarr.setText("");
		editfacultad.setText("");
	}

}
