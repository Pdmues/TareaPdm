package sv.ues.fia.carrera;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class CarreraEliminar extends Activity {
	EditText editECcarr;
	ControladorBDG18 controlhelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carrera_eliminar);
		controlhelper=new ControladorBDG18 (this);
		editECcarr=(EditText)findViewById(R.id.editECcarrera);
	}

	public void eliminarCarrera(View v)
	{
		if(TextUtils.isEmpty(editECcarr.getText().toString()))
			Toast.makeText(this, "El Campo esta vacio", Toast.LENGTH_SHORT).show();
		
		else		{
		String regEliminadas;
		Carrera carrera = new Carrera();
		carrera.setIdcarrera(editECcarr.getText().toString());
		controlhelper.abrir();
		regEliminadas=controlhelper.eliminar(carrera);
		controlhelper.cerrar();
		Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();}
	}
}