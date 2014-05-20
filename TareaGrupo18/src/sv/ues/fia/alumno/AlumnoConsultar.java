package sv.ues.fia.alumno;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AlumnoConsultar extends Activity {
	
	EditText  edtCon_carnet;
	EditText  edtCon_nombre;
	EditText  edtCon_apellido;
	EditText  edtCon_sexo;
	EditText  edtCon_ngrupo;
	EditText  edtCon_idcarrera;
	ControladorBDG18 helper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alumno_consultar);
		helper = new ControladorBDG18(this);
		edtCon_carnet = (EditText) findViewById(R.id.editCCInts);
		edtCon_nombre = (EditText) findViewById(R.id.editCCInts);
		edtCon_apellido = (EditText) findViewById(R.id.editCCInts);
		edtCon_sexo =(EditText) findViewById(R.id.editCCInts);
		edtCon_ngrupo =(EditText) findViewById(R.id.editCCInts);
		edtCon_idcarrera=(EditText) findViewById(R.id.editCCInts);
		
	}

	public void consultarAlumno(View v){
		helper.abrir();
		Alumno alumn = helper.consultarAlumno(edtCon_carnet.getText().toString());
		if(alumn == null)
			Toast.makeText(this, "El alumno con carnet " +
					edtCon_carnet.getText().toString() +
			" no fue encontrado", Toast.LENGTH_LONG).show();
			else
			{
				edtCon_carnet.setText(alumn.getCarnet().toString());
				edtCon_nombre.setText(alumn.getNombre().toString());
				edtCon_apellido.setText(alumn.getApellido().toString());
				edtCon_sexo.setText(alumn.getSexo().toString());
				edtCon_ngrupo.setText(alumn.getNgrupo());
				edtCon_idcarrera.setText(alumn.getIdcarrera());
			}
		
	
	}
	
	public void limpiarTexto(View v)
	{
		edtCon_carnet.setText("");
		edtCon_nombre.setText("");
		edtCon_apellido.setText("");
		edtCon_sexo.setText("");
		edtCon_ngrupo.setText("");
		edtCon_idcarrera.setText("");
		
	}
	
	

}
