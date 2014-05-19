package sv.ues.fia.trabajograduacion;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TrabajoGraduacionConsultar extends Activity {

	EditText editCNTgrad;
	EditText editNPerf;
	EditText editPAvance;
	ControladorBDG18 helper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trabajo_graduacion_consultar);
		helper = new ControladorBDG18(this);
		editCNTgrad = (EditText) findViewById(R.id.editCNTGrad);
		editNPerf = (EditText) findViewById(R.id.editCNPerfil);
		editPAvance = (EditText) findViewById(R.id.editCPavance);
	}

	public void consultarTrabajoGraduacion(View v) 
	{
		helper.abrir();
		TrabajoGraduacion tgard=helper.consultarTrabajoGraduacion(editCNTgrad.getText().toString());
		helper.cerrar();
		if(tgard == null)
		Toast.makeText(this, "La institucion con codigo " +
				editCNTgrad.getText().toString() +
		" no encontrado", Toast.LENGTH_LONG).show();
		else
		{
			editCNTgrad.setText(tgard.getNtg()+"");
			editNPerf.setText(tgard.getNperfil()+"");
			editPAvance.setText(tgard.getPorcentajea()+"");
		}
	}
	public void limpiarTexto(View v)
	{
		editCNTgrad.setText("");
		editNPerf.setText("");
		editPAvance.setText("");
	}

}
