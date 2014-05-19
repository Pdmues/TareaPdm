package sv.ues.fia.trabajograduacion;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TrabajoGraduacionInsertar extends Activity {

	ControladorBDG18 helper;
	EditText editNTG;
	EditText editNP;
	EditText editPA;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trabajo_graduacion_insertar);
		helper = new ControladorBDG18(this);
		editNTG = (EditText) findViewById(R.id.editINTGraduacion);
		editNP = (EditText) findViewById(R.id.editINPerfil);
		editPA = (EditText) findViewById(R.id.editIPAvance);
	}
	
	

	public void insertarTrabajoGraduacion(View v) 
	{
		String ntg=editNTG.getText().toString();
		String np=editNP.getText().toString();
		String pa=editPA.getText().toString();
		String regInsertados;
		TrabajoGraduacion tgraduacion=new TrabajoGraduacion();
		tgraduacion.setNtg(Integer.parseInt(ntg));
		tgraduacion.setNperfil(Integer.parseInt(np));
		tgraduacion.setPorcentajea(Float.parseFloat(pa));
		helper.abrir();
		regInsertados=helper.insertar(tgraduacion);
		helper.cerrar();
		Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
	}
	public void limpiarTexto(View v) 
	{
		editNTG.setText("");
		editNP.setText("");
		editPA.setText("");
	}
}
