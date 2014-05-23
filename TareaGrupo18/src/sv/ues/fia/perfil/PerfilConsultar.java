package sv.ues.fia.perfil;
import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PerfilConsultar extends Activity {
	EditText editNperfil;
	EditText editEperfil;
	EditText editOperfil;
	ControladorBDG18 helper;
 	@Override

 	protected void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
 		setContentView(R.layout.activity_perfil_consultar);
		helper = new ControladorBDG18(this);
		editNperfil = (EditText) findViewById(R.id.editNPer);
		editEperfil = (EditText) findViewById(R.id.editESTPer);
		editOperfil = (EditText) findViewById(R.id.editOBSPer);
}
	
public void consultarPerfil(View v) 
{
		helper.abrir();
		Perfil perfil=helper.consultarPerfil(editNperfil.getText().toString());
		helper.cerrar();
		if(perfil == null)
		Toast.makeText(this, "El perfil con codigo " +	editNperfil.getText().toString() + " no encontrado", Toast.LENGTH_LONG).show();
		else{
			editEperfil.setText(perfil.getEstado().toString());
			editOperfil.setText(perfil.getObservaciones().toString());
		}
}

 public void limpiarTexto(View v)
	{
		editEperfil.setText("");
		editEperfil.setText("");
		editEperfil.setText("");
 	}
 }