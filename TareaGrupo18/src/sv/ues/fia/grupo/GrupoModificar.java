package sv.ues.fia.grupo;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GrupoModificar extends Activity {
	ControladorBDG18 helper;
	EditText ngrupomodificar;
	EditText iddocentemodificar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grupo_modificar);
		helper=new ControladorBDG18(this);
		ngrupomodificar=(EditText)findViewById(R.id.editGrupoModificar);
		iddocentemodificar=(EditText)findViewById(R.id.editIdDocenteModificar);
		
	}

	public void actualizarGrupo(View v)
	  {
		if(TextUtils.isEmpty(ngrupomodificar.getText().toString())||TextUtils.isEmpty(iddocentemodificar.getText().toString()))
		{Toast.makeText(this, "Existe Campo vacio", Toast.LENGTH_SHORT).show();}
		else{
		Grupo g= new Grupo();
		g.setNgrupo(Integer.parseInt(ngrupomodificar.getText().toString()));
		g.setIddocente(iddocentemodificar.getText().toString());
		helper.abrir();
		String estado=helper.actualizar(g);
		helper.cerrar();
		Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();}
	  }

}
