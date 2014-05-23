package sv.ues.fia.perfil;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PerfilInsertar extends Activity {

	ControladorBDG18 helper;
	EditText editNumper;
	EditText editNestper;
	EditText editObsper;
	EditText editNgrupo;
	EditText editIDinstitucion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil_insertar);
		helper = new ControladorBDG18(this);
		editNumper = (EditText) findViewById(R.id.editNPerfil);
		editNestper = (EditText) findViewById(R.id.editEsPerfil);
		editObsper = (EditText) findViewById(R.id.editObPerfil);
		editNgrupo = (EditText) findViewById(R.id.editNumerogrupo);
		editIDinstitucion = (EditText) findViewById(R.id.editIDinstitucion);
	}

	public void insertarPerfil(View v) 
	{
		String Numperfil=editNumper.getText().toString();
		String Nestper = editNestper.getText().toString();
		String observacionesperfil=editObsper.getText().toString();
		String ngroup= editNgrupo.getText().toString();
		String insti=editIDinstitucion.getText().toString();
		String regInsertados;
		Perfil perfil=new Perfil();
		perfil.setNperfil1(Integer.parseInt(Numperfil));
		perfil.setEstado(Nestper);
		perfil.setObservaciones(observacionesperfil);
		perfil.setIdinstitucion(Integer.parseInt(insti));
		perfil.setNgrupo(Integer.parseInt(ngroup));
		helper.abrir();
		regInsertados=helper.insertar(perfil);
		helper.cerrar();
		Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
	}
	public void limpiarTexto(View v) 
	{
		editNumper.setText("");
		editNestper.setText("");
		editObsper.setText("");
		editNgrupo.setText("");
		editIDinstitucion.setText("");
	}

}