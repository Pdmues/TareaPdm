package sv.ues.fia.grupo;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GrupoConsultar extends Activity {
	EditText numerogrupoconsultar;
	EditText iddocenteconsultar;
	ControladorBDG18 helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grupo_consultar);
		helper=new ControladorBDG18(this);
		numerogrupoconsultar=(EditText)findViewById(R.id.editNumeroGrupoConsultar);
		iddocenteconsultar=(EditText)findViewById(R.id.editIdDocenteConsultar);
		}

	public void ConsultarGrupo(View v)
	{
		if(TextUtils.isEmpty(numerogrupoconsultar.getText().toString()))
		{Toast.makeText(this, "Existe Campo vacio", Toast.LENGTH_SHORT).show();}
		else{
		helper.abrir();
		Grupo grupo=helper.consultarGrupo(numerogrupoconsultar.getText().toString());
		helper.cerrar();
		if(grupo==null)
		{
			Toast.makeText(this, "El grupo con codigo " +
					numerogrupoconsultar.getText().toString() +" no encontrado", Toast.LENGTH_LONG).show();
		}
		else
			{iddocenteconsultar.setText(grupo.getIddocente().toString());}
		   }
	}
public void limpiarTexto(View v)
{
	numerogrupoconsultar.setText("");
	iddocenteconsultar.setText("");
}

	
}
