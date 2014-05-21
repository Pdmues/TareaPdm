package sv.ues.fia.grupo;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import sv.ues.fia.R.layout;
import sv.ues.fia.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GrupoInsertar extends Activity {
	ControladorBDG18 helper;
	EditText numerogrupoinsertar;
	EditText iddocenteinsertar;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grupo_insertar);
		helper = new ControladorBDG18(this);
		numerogrupoinsertar=(EditText)findViewById(R.id.editnumerodegrupoinsertar);
		iddocenteinsertar=(EditText)findViewById(R.id.editiddocenteinsertar);
	}


public void insertargrupo(View v)
{
String numero=numerogrupoinsertar.getText().toString();
String docente=iddocenteinsertar.getText().toString();
String regInsertados;
Grupo grup=new Grupo();
grup.setNgrupo(Integer.parseInt(numero));
grup.setIddocente(docente);
helper.abrir();
regInsertados=helper.insertar(grup);
helper.cerrar();
Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
}
public void limpiarTextogrupo(View v) 
{
	numerogrupoinsertar.setText("");
	iddocenteinsertar.setText("");
}

}
