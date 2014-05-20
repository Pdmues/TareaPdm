package sv.ues.fia.alumno;

import sv.ues.fia.R;
import sv.ues.fia.R.layout;
import sv.ues.fia.R.menu;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AlumnoInsertar extends Activity {

	ControladorBDG18 helper;
	EditText editCarnet;
	EditText editNombre;
	EditText editApellido;
	EditText editSexo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alumno_insertar);
		helper = new ControladorBDG18(this);
		editCarnet = (EditText) findViewById(R.id.editCarnet);
		editNombre = (EditText) findViewById(R.id.editNombre);
		editApellido = (EditText) findViewById(R.id.editApellido);
		editSexo = (EditText) findViewById(R.id.editSexo);
		//editNgrupo = (EditText) findViewById(R.id.editNgrupo);
		//editIdCarrera = (EditText) findViewById(R.id.editIdCarrera);
	}


	public void insertarAlumno(View v) 
	{
		String carnet=editCarnet.getText().toString();
		String nombre=editNombre.getText().toString();
		String apellido=editApellido.getText().toString();
		String sexo=editSexo.getText().toString();
		int idcarrera=0;
		int ngrupo=0;
	    //String regInsertados;
		Alumno alumn = new Alumno();
		alumn.setCarnet(carnet);
		alumn.setNombre(nombre);
		alumn.setApellido(apellido);
		alumn.setSexo(sexo);
		alumn.setNgrupo(ngrupo);
		alumn.setIdcarrera(idcarrera);
		
		helper.abrir();
	//	regInsertados=helper.insertar(alumno);
		helper.cerrar();
	//	Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
	}
	public void limpiarTexto(View v) 
	{
		editCarnet.setText("");
		editNombre.setText("");
		editApellido.setText("");
		editSexo.setText("");
		//editNgrupo.setText("");
		//editIdCarrera.setText("");
	}

}