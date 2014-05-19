package sv.ues.fia.trabajograduacion;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TrabajoGraduacionEliminar extends Activity {
	EditText editECTG;
	ControladorBDG18 controlhelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trabajo_graduacion_eliminar);
		controlhelper=new ControladorBDG18 (this);
		editECTG=(EditText)findViewById(R.id.editECTGraduacion);
	}


	public void eliminarTrabajoGraduacion(View v)
	{
		String regEliminadas;
		TrabajoGraduacion tgraduacion=new TrabajoGraduacion();
		tgraduacion.setNtg(Integer.parseInt(editECTG.getText().toString()));
		controlhelper.abrir();
		regEliminadas=controlhelper.eliminar(tgraduacion);
		controlhelper.cerrar();
		Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
	}

}
