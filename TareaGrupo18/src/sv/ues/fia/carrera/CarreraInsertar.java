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
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carrera_insertar);
		helper = new ControladorBDG18(this);
		editIdcarr = (EditText) findViewById(R.id.editICcarrera);
		editNmcarr = (EditText) findViewById(R.id.editINNomb);
	}

	public void insertarCarrera(View v) 
	{
		String ccarrera=editIdcarr.getText().toString();
		String Ncarr= editNmcarr.getText().toString();
		String regInsertados;
		Carrera carrera=new Carrera();
		carrera.setIdcarrera(ccarrera);
		carrera.setNombcarrera(Ncarr);
		helper.abrir();
		regInsertados=helper.insertar(carrera);
		helper.cerrar();
		Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
	}
	public void limpiarTexto(View v) 
	{
		editIdcarr.setText("");
		editNmcarr.setText("");
	}

}
