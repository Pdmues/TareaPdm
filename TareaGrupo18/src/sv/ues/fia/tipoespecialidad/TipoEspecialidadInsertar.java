package sv.ues.fia.tipoespecialidad;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
//import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoEspecialidadInsertar extends Activity {

	ControladorBDG18 helper;
	EditText editidespecialidad;
	EditText editnespecialidad;
public void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_tipo_especialidad_insertar);
	helper =new ControladorBDG18(this);
	editidespecialidad = (EditText) findViewById(R.id.editIDEspecialidad);
	editnespecialidad = (EditText) findViewById(R.id.editnomespecialidad);
}
public void insertarTipoEspecialidad(View v){
	String idTEspecialidad = editidespecialidad.getText().toString();
	String  nomespecialidad = editnespecialidad.getText().toString();
	String regInsertados;
	TipoEspecialidad tespecialidad=new TipoEspecialidad();
	tespecialidad.setIDespecialidad(Integer.parseInt(idTEspecialidad));
	tespecialidad.setNombreEspecialidad(nomespecialidad);
	helper.abrir();
	regInsertados=helper.insertar(tespecialidad);
	Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
}
public void limpiarTexto(View v) 
{
	editidespecialidad.setText("");
	editnespecialidad.setText("");
}

}
