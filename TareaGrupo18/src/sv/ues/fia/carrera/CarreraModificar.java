package sv.ues.fia.carrera;
import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

 public class CarreraModificar extends Activity {
	ControladorBDG18 helper;
	EditText editIDcarr;
	EditText editNMcarr;
	EditText editFac;
 	@Override

protected void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
 		setContentView(R.layout.activity_carrera_modificar);
		helper = new ControladorBDG18(this);
		editIDcarr = (EditText) findViewById(R.id.editCCcarrera);
		editNMcarr = (EditText) findViewById(R.id.editCCcarr);
		editFac= (EditText) findViewById(R.id.editCCFarrera);
}
 	
public void actualizarCarrera(View v) 
{
		Carrera carrera = new Carrera();
		carrera.setIdcarrera(editIDcarr.getText().toString());
		carrera.setNombcarrera(editNMcarr.getText().toString());
		carrera.setIdfacultad(editFac.getText().toString());
		helper.abrir();
		String estado = helper.actualizar(carrera);
		helper.cerrar();
		Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
}

public void limpiarTexto(View v) 
 {
		editIDcarr.setText("");
		editNMcarr.setText("");
		editFac.setText("");
 }
}