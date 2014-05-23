package sv.ues.fia.grupo;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GrupoEliminar extends Activity {
	ControladorBDG18 helper;
	EditText eliminargrupo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grupo_eliminar);
		helper= new ControladorBDG18(this);
		eliminargrupo=(EditText)findViewById(R.id.editGrupoEliminar);
	}

	public void eliminargrupo(View v)
	{
		if(TextUtils.isEmpty(eliminargrupo.getText().toString()))
		{Toast.makeText(this, "Existe Campo vacio", Toast.LENGTH_SHORT).show();}
		else{
		String regEliminadas;
		Grupo g= new Grupo();
		g.setNgrupo(Integer.parseInt(eliminargrupo.getText().toString())) ;
		helper.abrir();
		regEliminadas= helper.eliminar(g);
		helper.cerrar();
		Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
	        }
	}

}
