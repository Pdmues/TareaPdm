package sv.ues.fia.perfil;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PerfilModificar extends Activity {

	ControladorBDG18 helper;
	EditText editNperf;
	EditText editEperf;
	EditText editOperf;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil_modificar);
		helper = new ControladorBDG18(this);
		editNperf = (EditText) findViewById(R.id.editCCperfil);
		editEperf = (EditText) findViewById(R.id.editCCperf);
		editOperf = (EditText) findViewById(R.id.editCCper);
	}

	public void actualizarPerfil(View v) 
	{
		Perfil perfil = new Perfil();
		perfil.setNperfil(Integer.parseInt(editNperf.getText().toString()));
		perfil.setEstado(editEperf.getText().toString());
		perfil.setObservaciones(editEperf.getText().toString());
		helper.abrir();
		String estado = helper.actualizar(perfil);
		helper.cerrar();
		Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
	}
	public void limpiarTexto(View v) 
	{
		editNperf.setText("");
		editEperf.setText("");
		editOperf.setText("");
	}
	
}
