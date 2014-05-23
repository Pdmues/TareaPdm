package sv.ues.fia.trabajograduacion;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TrabajoGraduacionModificar extends Activity {

	ControladorBDG18 helper;
	EditText editMCTG;
	EditText editMNPer;
	EditText editMPavan;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trabajo_graduacion_modificar);
		helper = new ControladorBDG18(this);
		editMCTG = (EditText) findViewById(R.id.editMCTGraduacion);
		editMNPer = (EditText) findViewById(R.id.editMNPerfil);
		editMPavan = (EditText) findViewById(R.id.editMPavance);
	}

	public void actualizarTrabajoGraduacion(View v) 
	{
		if(editMCTG.getText().toString().equals("")||editMNPer.getText().toString().equals("")
				||editMPavan.getText().toString().equals(""))
		{
			Toast.makeText(this, "Campos vacios", Toast.LENGTH_LONG).show();
			editMCTG.setText("");
			editMNPer.setText("");
			editMPavan.setText("");
		}
		else
		{
			TrabajoGraduacion tgraduacion = new TrabajoGraduacion();
			tgraduacion.setNtg(Integer.parseInt(editMCTG.getText().toString()));
			tgraduacion.setNperfil(Integer.valueOf(editMNPer.getText().toString()));
			tgraduacion.setPorcentajea(Float.valueOf(editMPavan.getText().toString()));
			helper.abrir();
			String estado = helper.actualizar(tgraduacion);
			helper.cerrar();
			Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
		}
	}
	public void limpiarTexto(View v) 
	{
		editMCTG.setText("");
		editMNPer.setText("");
		editMPavan.setText("");
	}

}
